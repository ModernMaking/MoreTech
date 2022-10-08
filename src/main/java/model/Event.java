package model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String description;

    private Date date;

    public Event() {

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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event(String name, String description, Date date)
    {
        this.name=name;
        this.description=description;
        this.date=date;
    }
}
