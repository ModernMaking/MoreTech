package model;

import javax.persistence.*;

@Entity
@Table
public class TextVR {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "palace_id")
    private Palace palace;

    private float x;

    private float y;

    private float z;

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
