package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Certificate {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private int nominal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Certificate(String name, int nominal)
    {
        this.name=name;
        this.nominal=nominal;
    }
}
