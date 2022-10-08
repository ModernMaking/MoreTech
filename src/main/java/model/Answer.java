package model;

import javax.persistence.*;

@Entity
@Table
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_variant_id")
    private AnswerVariant answerVariant;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AnswerVariant getAnswerVariant() {
        return answerVariant;
    }

    public void setAnswerVariant(AnswerVariant answerVariant) {
        this.answerVariant = answerVariant;
    }

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
