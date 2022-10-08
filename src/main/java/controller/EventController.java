package controller;

import model.Event;
import model.EventParticipation;
import model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repo.EventParticipationRepository;
import repo.EventRepository;
import repo.UserRepository;

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
    EventParticipationRepository eventParticipationRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private UserRepository userRepository;

    @PostMapping("/add")
    public void addEvent(String name, String description, Date date)
    {
        Event event = new Event(name,description,date);
        eventRepository.save(event);
    }

    @PostMapping("/{event_id}/confirmParticipation")
    public void confirm(Long userId, @PathVariable Long event_id)
    {
        User user = userRepository.findById(userId).get();
        Event event = eventRepository.findById(event_id).get();
        EventParticipation eventParticipation = new EventParticipation(user,event);
        eventParticipationRepository.save(eventParticipation);
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


}
