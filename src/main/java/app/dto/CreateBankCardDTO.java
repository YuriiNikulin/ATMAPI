package app.dto;

import app.model.Address;
import app.model.SexOfUser;
import sun.util.resources.LocaleData;

import java.util.Date;

public class CreateBankCardDTO {

    private String user_name;
    private int card_number;
    private Date user_birthday;
    private SexOfUser sex;
    private Address address;

    public CreateBankCardDTO() {
    }

    public CreateBankCardDTO(String user_name, int card_number, Date user_birthday, SexOfUser sex, Address address) {
        this.user_name = user_name;
        this.card_number = card_number;
        this.user_birthday = user_birthday;
        this.sex = sex;
        this.address = address;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getCard_number() {
        return card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
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
}
