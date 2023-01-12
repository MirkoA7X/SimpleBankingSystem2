package banking;

public class Customer {
    private String cardNumber;
    private String pinNumber;
    private int balance;

    public Customer(String cardNumber, String pinNumber, int balance) {
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public int getBalance() {
        return balance;
    }
}