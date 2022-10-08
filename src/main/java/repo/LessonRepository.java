package repo;

import model.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    public List<Lesson> findAllByCourseId(Long course_id);
    public Lesson getById(Long id);
}
