package controller;

import model.ForumMessage;
import model.ForumTopic;
import model.User;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repo.ForumMessageRepository;
import repo.ForumTopicRepository;
import repo.UserTokenRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    ForumTopicRepository forumTopicRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    ForumMessageRepository forumMessageRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    UserTokenRepository userTokenRepository;

    @PostMapping("/createTopic")
    public Long createTopic(Long id, String token, String name, String description)
    {
        User user = userTokenRepository.getByUserIdAndToken(id,token).getUser();
        ForumTopic forumTopic = new ForumTopic(name,description,user);
        forumTopicRepository.save(forumTopic);
        return forumTopic.getId();
    }

    @GetMapping("/topics")
    public List<ForumTopic> getTopicList()
    {
        List<ForumTopic> forumTopics = new ArrayList<>();
        Iterable<ForumTopic> topics = forumTopicRepository.findAll();
        topics.forEach(new Consumer<ForumTopic>() {
            @Override
            public void accept(ForumTopic topic) {
                forumTopics.add(topic);
            }
        });
        return forumTopics;
    }

    @GetMapping("/")
    public ModelAndView getForumPage(Model model, String token, Long userId)
    {
        List<ForumTopic> topics = getTopicList();
        model.addAttribute("topics",topics);
        model.addAttribute("token",token);
        model.addAttribute("userId",userId);
        return new ModelAndView("forumTopics");
    }

    @GetMapping("/topic/{id}")
    public ModelAndView getForumTopic(@PathVariable Long id, Model model)
    {
        ForumTopic forumTopic = forumTopicRepository.findById(id).get();
        model.addAttribute("forumTopic",forumTopic);
        List<ForumMessage> forumMessages = forumMessageRepository.findAllByTopicId(id);
        model.addAttribute("messages",forumMessages);
        return new ModelAndView("topicMessages");
    }



    @PostMapping("/topic/{topic_id}/sendMessage")
    public Long sendMessage(@PathVariable Long topic_id, Long userId, String token, String text)
    {
        User user = userTokenRepository.getByUserIdAndToken(userId,token).getUser();
        ForumTopic topic = forumTopicRepository.getById(topic_id);
        ForumMessage message = new ForumMessage(user,topic,text);
        forumMessageRepository.save(message);
        return message.getId();
    }

}
