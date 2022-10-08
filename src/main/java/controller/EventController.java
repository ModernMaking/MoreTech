package controller;

import model.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repo.*;

import java.time.LocalDateTime;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/event")
public class EventController {
    @org.springframework.beans.factory.annotation.Autowired(required=true)
    EventRepository eventRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    TagRepository tagRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    EventTagRepository eventTagRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    EventParticipationRepository eventParticipationRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private UserRepository userRepository;

    @PostMapping("/add")
    public Long addEvent(String name, String description, Date date)
    {
        Event event = new Event(name,description,date);
        eventRepository.save(event);
        return event.getId();
    }

    @PostMapping("/{event_id}/confirmParticipation")
    public void confirm(Long userId, @PathVariable Long event_id)
    {
        User user = userRepository.findById(userId).get();
        Event event = eventRepository.findById(event_id).get();
        EventParticipation eventParticipation = new EventParticipation(user,event);
        eventParticipationRepository.save(eventParticipation);
    }

    @PostMapping("/{event_id}/addTag")
    public void addTag(Long tagId, @PathVariable Long event_id)
    {
        Event event = eventRepository.findById(event_id).get();
        Tag tag = tagRepository.findById(tagId).get();
        EventTag eventTag = new EventTag(event,tag);
        eventTagRepository.save(eventTag);
    }

    @GetMapping("/eventList")
    public List<Event> getAllEvents()
    {
        List<Event> eventList = new ArrayList<>();
        Iterable<Event> event = eventRepository.findAll();
        event.forEach(new Consumer<Event>() {
            @Override
            public void accept(Event event) {
                eventList.add(event);
            }
        });
        return eventList;
    }

    @GetMapping("/eventPage")
    public ModelAndView getEventPage(Model model)
    {
        model.addAttribute("events",getAllEvents());
        return new ModelAndView("eventPage");
    }

    @GetMapping("/byTag/{tag_id}")
    public List<Event> getEventsByTag(@PathVariable Long tag_id)
    {
        List<EventTag> eventTags = eventTagRepository.findAllByTagId(tag_id);
        List<Event> eventList = new ArrayList<>();
        for (EventTag eventTag: eventTags)
        {
            eventList.add(eventTag.getEvent());
        }
        return eventList;
    }



}
