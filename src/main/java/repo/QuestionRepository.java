package repo;

import com.example.vtb2.BloomTaxonomyLevel;
import model.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question,Long> {
    public List<Question> findAllByCourseIdAndLevel(Long course_id, BloomTaxonomyLevel level);
}
