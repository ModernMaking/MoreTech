package model;

import com.example.vtb2.BloomTaxonomyLevel;

import javax.persistence.*;

@Entity
@Table
public class Question {

    public Question() {

    }

    public enum QuestionType {
        TEST,
        STRING_ANSWER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String text;

    private BloomTaxonomyLevel level;

    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public Question(String text, BloomTaxonomyLevel level, Course course, QuestionType type)
    {
        this.text=text;
        this.level=level;
        this.course=course;
        this.questionType=type;
    }
}
