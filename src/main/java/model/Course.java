package model;

import javax.persistence.*;

@Entity
@Table
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    public Course() {

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

    public Course(String name, String description)
    {
        this.name=name;
        this.description=description;
    }
}
