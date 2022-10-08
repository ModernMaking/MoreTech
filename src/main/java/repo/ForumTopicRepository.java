package repo;

import model.ForumTopic;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ForumTopicRepository extends CrudRepository<ForumTopic, Long> {
    public ForumTopic getById(Long id);
    public Optional<ForumTopic> findById(Long id);
}
