package controller;

import model.ForumTopic;
import model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repo.ForumTopicRepository;
import repo.UserTokenRepository;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    ForumTopicRepository forumTopicRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    UserTokenRepository userTokenRepository;

    @PostMapping("/createTopic")
    public Long createTopic(Long id, String token, String name, String description)
    {
        User user = userTokenRepository.getByIdAndToken(id,token);
        ForumTopic forumTopic = new ForumTopic(name,description,user);
        forumTopicRepository.save(forumTopic);
        return forumTopic.getId();
    }

    @GetMapping("/topic/{id}")
    public ModelAndView getForumTopic(@PathVariable Long id, Model model)
    {
        ForumTopic forumTopic = forumTopicRepository.findById(id).get();
        model.addAttribute("forumTopic",forumTopic);
        return new ModelAndView("getForumTopic");
    }
}
