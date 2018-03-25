package app.model;

import javax.persistence.*;

@Entity(name = "bank_cards")
public class BankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    @Column(name = "card_number", length = 16)
    private int cardNumber;

    @Column(name = "score")
    private double score;

    @Column(name = "card_pass", nullable = false)
    private String pass;

    public BankCard() {
    }

    public BankCard(User user, int cardNumber, double score, String pass) {
        this.user = user;
        this.cardNumber = cardNumber;
        this.score = score;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "user=" + user +
                ", cardNumber='" + cardNumber + '\'' +
                ", score=" + score +
                '}';
    }
}
