package model;

import javax.persistence.*;

@Entity
@Table
public class CoinIncome {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int sum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String description;

    public CoinIncome() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSum(int sum)
    {
        this.sum=sum;
    }

    public int getSum() {
        return sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CoinIncome(User user, int sum, String description)
    {
        this.user=user;
        this.sum=sum;
        this.description=description;
    }

}
