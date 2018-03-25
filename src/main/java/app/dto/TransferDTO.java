package app.dto;

public class TransferDTO {

    private int senderCardNumber;
    private int recipientCardNumber;
    private double amountForTranster;
    private String senderPass;

    public TransferDTO() {
    }

    public TransferDTO(int senderCardNumber, int recipientCardNumber, double amountForTranster, String senderPass) {
        this.senderCardNumber = senderCardNumber;
        this.recipientCardNumber = recipientCardNumber;
        this.amountForTranster = amountForTranster;
        this.senderPass = senderPass;
    }

    public int getSenderCardNumber() {
        return senderCardNumber;
    }

    public void setSenderCardNumber(int senderCardNumber) {
        this.senderCardNumber = senderCardNumber;
    }

    public int getRecipientCardNumber() {
        return recipientCardNumber;
    }

    public void setRecipientCardNumber(int recipientCardNumber) {
        this.recipientCardNumber = recipientCardNumber;
    }

    public double getAmountForTranster() {
        return amountForTranster;
    }

    public void setAmountForTranster(double amountForTranster) {
        this.amountForTranster = amountForTranster;
    }

    public String getSenderPass() {
        return senderPass;
    }

    public void setSenderPass(String senderPass) {
        this.senderPass = senderPass;
    }
}
