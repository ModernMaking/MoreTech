package controller;

import model.*;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/user")
public class UserController {

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private UserRepository userRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    NewsRepository newsRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private UserTokenRepository userTokenRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private CoinIncomesRepository coinIncomesRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private CoinTransferRepository coinTransferRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private ProductBuyingRepository productBuyingRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    ProductRepository productRepository;

    @GetMapping("/")
    public ModelAndView getIndex(Model model)
    {
        List<News> news = getNews();
        model.addAttribute("news",news);
        return new ModelAndView("index");
    }

    public List<News> getNews()
    {
        List<News> news = new ArrayList<>();
        Iterable<News> n = newsRepository.findAll();
        n.forEach(new Consumer<News>() {
            @Override
            public void accept(News news1) {
                news.add(news1);
            }
        });
        return news;
    }

    @PostMapping("/add")
    public void add(String nickName, String password)
    {
        if (!userRepository.existsByNickName(nickName))
        {
            User u = new User(nickName,password, User.UserType.WORKER);
            userRepository.save(u);
        }
    }

    @PostMapping("/addAdmin")
    public void addAdmin(String nickName, String password, String firstName, String secondName)
    {
        User admin = User.createAdmin(nickName,password,firstName,secondName);
        userRepository.save(admin);
    }

    @PostMapping("/sendCoins")
    public void sendCoins(Long userId, int sum, String description)
    {
        CoinIncome coinIncome = new CoinIncome(userRepository.findById(userId).get(),sum,description);
        coinIncomesRepository.save(coinIncome);
    }

    @PostMapping("/sendCoinsFromTo")
    public boolean sendCoinsFromTo(Long fromId, Long toId, int sum, String description)
    {
        User from = userRepository.findById(fromId).get();
        User to = userRepository.findById(toId).get();
        int incomes = getUserIncomes(from);
        if (incomes>=sum)
        {
            CoinTransfer coinTransfer = new CoinTransfer(to,from,sum);
            coinTransferRepository.save(coinTransfer);
            return true;
        }
        return false;
    }

    @GetMapping("/register")
    public ModelAndView register(Model model)
    {
        User user = new User();
        model.addAttribute("user",user);
        return new ModelAndView("register1");
    }

    @PostMapping("/register")
    public ModelAndView registerFinished(@ModelAttribute User user, Model model)
    {
        if (!userRepository.existsByNickName(user.getNickName()))
        {
            User u = new User(user.getNickName(),user.getPassword(), user.getFirstName(), user.getSecondName());
            userRepository.save(u);
            model.addAttribute("user",u);
            return new ModelAndView("userPage1");
        }
        return new ModelAndView("login");
    }



    @GetMapping("/find")
    public boolean userExists(String nickName, String password)
    {
        return userRepository.getUserByNickNameAndAndPassword(nickName,password) != null;
    }

    public int getUserIncomes(User user)
    {
        List<CoinIncome> incomeList = coinIncomesRepository.findAllByUser(user);
        int incomeSum = 0;
        for (CoinIncome income:
                incomeList) {
            incomeSum+=income.getSum();
        }

        List<CoinTransfer> coinTransferList = coinTransferRepository.findAllByReceiver(user);
        for (CoinTransfer transfer: coinTransferList)
        {
            incomeSum+=transfer.getSum();
        }

        return incomeSum;
    }

    public int getUserSpends(User user)
    {
        List<CoinTransfer> coinTransferList = coinTransferRepository.findAllByFrom(user);
        int spends = 0;
        for (CoinTransfer coinTransfer: coinTransferList)
        {
            spends+=coinTransfer.getSum();
        }

        List<ProductByuing> productByuingList = productBuyingRepository.findAllByBuyer(user);
        for (ProductByuing productByuing: productByuingList)
        {
            spends+=productByuing.getSum();
        }
        return spends;
    }

    public int getUserBalance(User user)
    {
        return getUserIncomes(user) - getUserSpends(user);
    }

    @PostMapping (value = "/login")
    public ModelAndView login(@ModelAttribute User user, Model model)
    {
        User u = userRepository.getUserByNickNameAndAndPassword(user.getNickName(),user.getPassword());
        if (u!=null)
        {
            model.addAttribute("user",u);
            String token = RandomStringUtils.randomAlphanumeric(200);
            UserToken userToken = new UserToken(u, token);
            userTokenRepository.save(userToken);
            model.addAttribute("token",token);

            int incomeSum = getUserIncomes(u);
            int balance = getUserBalance(u);
            model.addAttribute("income_sum",incomeSum);
            model.addAttribute("balance",balance);

            if (u.getUserType()== User.UserType.WORKER)
                return new ModelAndView("userPage1");
            if (u.getUserType()== User.UserType.ADMIN)
                return new ModelAndView("adminPage");
        }
        model.addAttribute("error","Неверно введен логин или пароль");
        user.setNickName("");
        user.setPassword("");
        return new ModelAndView("login");
    }


    @GetMapping(value = "/login")
    public ModelAndView loginForm(Model model)
    {
        model.addAttribute("user",new User());
        return new ModelAndView("login1");
    }

    @PostMapping("/buyProduct")
    public boolean buyProduct(Long userId, Long productId)
    {
        User user = userRepository.findById(userId).get();
        Product product = productRepository.findById(productId).get();
        if (product.isProductExists() && getUserBalance(user)>=10) {
            ProductByuing productByuing = new ProductByuing(user, product, 10);
            productBuyingRepository.save(productByuing);
            product.setProductExists(false);
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @GetMapping("/all")
    public List<User> getAll()
    {
        List<User> users = new ArrayList<>();
        Iterable<User> users1 = userRepository.findAll();
        users1.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                users.add(user);
            }
        });
        return users;
    }

    @GetMapping("/employeeList")
    public ModelAndView getEmployeeList(Model model)
    {
        model.addAttribute("users",getAll());
        return new ModelAndView("employeeList");
    }
}
