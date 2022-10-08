package controller;

import model.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repo.TagRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/tag")
public class TagController {

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    TagRepository tagRepository;

    @PostMapping("/add")
    public Long addTag(String name)
    {
        Tag tag = new Tag(name);
        tagRepository.save(tag);
        return tag.getId();
    }

    @GetMapping("/list")
    public List<Tag> getAll()
    {
        List<Tag> tagList = new ArrayList<>();
        Iterable<Tag> tags = tagRepository.findAll();
        tags.forEach(new Consumer<Tag>() {
            @Override
            public void accept(Tag tag) {
                tagList.add(tag);
            }
        });
        return  tagList;
    }
}
