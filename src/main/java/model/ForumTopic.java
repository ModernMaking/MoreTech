package model;

import javax.persistence.*;

@Entity
@Table
public class ForumTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public ForumTopic() {

    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ForumTopic(String name, String description, User owner)
    {
        this.name=name;
        this.description=description;
        this.owner=owner;
    }
}
