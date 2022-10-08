package model;

import javax.persistence.*;

@Entity
@Table
public class Rectangle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "palace_id")
    private Palace palace;

    private float width;

    private float length;

    private float height;

    private float x0;

    private float y0;

    private float z0;

    private String color;

    public Palace getPalace() {
        return palace;
    }

    public void setPalace(Palace palace) {
        this.palace = palace;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
