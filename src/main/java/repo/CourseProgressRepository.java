package repo;

import model.Course;
import model.CourseProgress;
import org.springframework.data.repository.CrudRepository;

public interface CourseProgressRepository extends CrudRepository<CourseProgress, Long> {
    public boolean countByIdAndCourse(Long id, Course course);
}
