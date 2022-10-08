package model;

import javax.persistence.*;

@Entity
@Table
public class CoinTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int sum;

    @ManyToOne
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private User from;

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public CoinTransfer(int sum, User receiver) {
        this.sum = sum;
        this.receiver = receiver;
    }

    public CoinTransfer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getReceiver() {
        return receiver;
    }

    public int getSum()
    {
        return sum;
    }

    public CoinTransfer(User receiver, User from, int sum)
    {
        this.receiver=receiver;
        this.from=from;
        this.sum=sum;
    }
}
