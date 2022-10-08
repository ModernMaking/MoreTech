package model;

import javax.persistence.*;

@Entity
@Table
public class ForumMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private ForumTopic topic;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ForumTopic getTopic() {
        return topic;
    }

    public void setTopic(ForumTopic topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
