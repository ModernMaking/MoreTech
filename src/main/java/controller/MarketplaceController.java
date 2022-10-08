package controller;

import model.Product;
import model.ProductByuing;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import repo.ProductBuyingRepository;
import repo.ProductRepository;
import repo.UserRepository;
import repo.UserTokenRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/marketplace")
public class MarketplaceController {

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    ProductRepository productRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private UserRepository userRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private UserTokenRepository userTokenRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private ProductBuyingRepository productBuyingRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        Iterable<Product> product = productRepository.findAll();
        List<Product> products = new ArrayList<>();
        product.forEach(new Consumer<Product>() {
            @Override
            public void accept(Product product) {
                if (product.isProductExists())
                    products.add(product);
            }
        });
        return products;
    }

    @GetMapping("/productPage")
    public ModelAndView getProductPage(Model model, String token, Long id)
    {
        model.addAttribute("token",token);
        model.addAttribute("id",id);
        User user = userTokenRepository.getByUserIdAndToken(id,token).getUser();
        model.addAttribute("user",user);
        model.addAttribute("products",getAllProducts());
        return new ModelAndView("productPage");
    }

    @PostMapping("/addProduct")
    public void addProduct(String name, Long ownerId)
    {
        User owner = userRepository.findById(ownerId).get();
        Product product = new Product(name,owner);
        productRepository.save(product);
    }



}
