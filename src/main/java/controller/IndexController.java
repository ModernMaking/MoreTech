package controller;

import model.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import repo.NewsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Controller
@RequestMapping("/")
public class IndexController {

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    NewsRepository newsRepository;

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
}
