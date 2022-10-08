package repo;

import model.Event;
import model.EventTag;
import model.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventTagRepository extends CrudRepository<EventTag, Long> {
    public List<EventTag> findAllByTag(Tag tag);
    public List<EventTag> findAllByTagId(Long tag_id);
    public List<EventTag> findAllByEvent(Event event);
    public List<EventTag> findAllByEventId(Long event_id);
}
