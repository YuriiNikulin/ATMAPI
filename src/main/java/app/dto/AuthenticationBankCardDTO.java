package app.dto;

public class AuthenticationBankCardDTO {

    private int cardNumber;
    private String userPass;

    public AuthenticationBankCardDTO() {
    }

    public AuthenticationBankCardDTO(int cardNumber, String userPass) {
        this.cardNumber = cardNumber;
        this.userPass = userPass;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
