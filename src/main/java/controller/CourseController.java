package controller;

import com.example.vtb2.BloomTaxonomyLevel;
import model.Course;
import model.Question;
import org.springframework.web.bind.annotation.*;
import repo.CourseRepository;
import repo.QuestionRepository;

import java.util.HashMap;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/course")
public class CourseController {
    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private CourseRepository courseRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private QuestionRepository questionRepository;

    @GetMapping("/list")
    public HashMap<Long,String> getAllCourses()
    {
        List<Course> courses = courseRepository.findAll();
        HashMap<Long,String> answer = new HashMap<>();
        for (Course c:
             courses) {
            answer.put(c.getId(),c.getName());
        }
        return answer;
    }

    @PostMapping("/add")
    public Long addCourse(String name, String description)
    {
        Course course = new Course(name,description);
        courseRepository.save(course);
        return course.getId();
    }

    @GetMapping(value = "/{id}")
    public Course getCourse(@PathVariable Long id)
    {
        return courseRepository.findById(id).get();
    }

    @PostMapping(value = "/{id}/addQuestion")
    public Long addQuestion(@PathVariable Long id, String text, BloomTaxonomyLevel level, Question.QuestionType type)
    {
        Question question = new Question(text, level, courseRepository.findById(id).get(), type);
        questionRepository.save(question);
        return question.getId();
    }

    @GetMapping(value = "/{id}/questions/{level}")
    public List<Question> getQuestions(@PathVariable("id") Long id, @PathVariable("level") BloomTaxonomyLevel level)
    {
        return questionRepository.findAllByCourseIdAndLevel(id,level);
    }


}
