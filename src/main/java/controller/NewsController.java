package controller;

import model.News;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repo.NewsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/news")
public class NewsController {
    @org.springframework.beans.factory.annotation.Autowired(required=true)
    NewsRepository newsRepository;

    @GetMapping("/all")
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
    public Long addNews(String name, String description)
    {
        News news = new News(name,description);
        newsRepository.save(news);
        return news.getId();
    }
}
