package model;

import javax.persistence.*;

@Entity
@Table
public class Palace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int width;

    private int height;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
