package repo;

import model.Event;
import model.EventParticipation;
import model.User;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface EventParticipationRepository extends CrudRepository<EventParticipation,Long> {
    public List<EventParticipation> findAllByUser(User user);
    public List<EventParticipation> findAllByUserId(Long user_id);
}
