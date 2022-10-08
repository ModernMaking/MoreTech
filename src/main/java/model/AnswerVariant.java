package model;

import javax.persistence.*;

@Entity
@Table
public class AnswerVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String text;

    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
