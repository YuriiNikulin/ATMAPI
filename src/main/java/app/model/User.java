package app.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "user_birthday", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Column(name = "user_sex", nullable = false)
    @Enumerated(EnumType.STRING)
    private SexOfUser sex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_address", nullable = false)
    private Address address;

    @Column(name = "user_bankCardList")
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<BankCard> bankCardList;

    public User() {
    }

    public User(String name, String surname, Date birthday, SexOfUser sex, Address address, List<BankCard> bankCardList) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.bankCardList = bankCardList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public SexOfUser getSex() {
        return sex;
    }

    public void setSex(SexOfUser sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<BankCard> getBankCardList() {
        return bankCardList;
    }

    public void setBankCardList(List<BankCard> bankCardList) {
        this.bankCardList = bankCardList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", address=" + address +
                ", bankCardList=" + bankCardList +
                '}';
    }
}
