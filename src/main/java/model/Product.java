package model;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private boolean productExists;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Product() {

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isProductExists() {
        return productExists;
    }

    public void setProductExists(boolean productExists) {
        this.productExists = productExists;
    }

    public Product(String name, User owner)
    {
        this.name=name;
        this.owner=owner;
        this.productExists =true;
    }
}
