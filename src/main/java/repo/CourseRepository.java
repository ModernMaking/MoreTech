package repo;

import model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {

    public List<Course> findAll();
    public Optional<Course> findById(Long id);
}
