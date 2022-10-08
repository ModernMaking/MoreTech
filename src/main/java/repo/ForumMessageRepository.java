package repo;

import model.ForumMessage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ForumMessageRepository extends CrudRepository<ForumMessage, Long> {
    public List<ForumMessage> findAllByTopicId(Long topicId);
}
