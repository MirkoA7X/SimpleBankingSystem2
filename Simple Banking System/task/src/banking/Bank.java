package banking;

import java.util.*;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();
    private List<String> cards = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addCustomer() {
        String cardNumber = generateCardNumber();
        String pinNumber = generatePIN();

        Customer customer = new Customer(cardNumber, pinNumber, 0);
        customerList.add(customer);
        cards.add(cardNumber);
        System.out.println("Your card has been created\n" +
                "Your card number:\n" + cardNumber +
                "\nYour card PIN:\n" + pinNumber + "\n");
    }
    public Customer login() {
        System.out.println("Enter your card number:");
        String cardNumber = scanner.nextLine();
        System.out.println("Enter your PIN:");
        String pinNumber = scanner.nextLine();

        Customer customer = findCustomer(cardNumber, pinNumber);
        if (customer != null) {
            System.out.println("You have successfully logged in!");
            return customer;
        } else {
            System.out.println("Wrong card number or PIN!");
        }
        return null;
    }

    private String generateCardNumber() {
        Random random = new Random();

        while (true) {
            final String BIN = "400000";
            String accountIdentifier = String.format("%09d", random.nextInt(999999999) + 1);
            String cardNumber = BIN + accountIdentifier + generateChecksum(BIN + accountIdentifier);

            if (checkCardNumberUniqueness(cardNumber)) {
                return cardNumber;
            }
        }
    }

    public int generateChecksum(String numberString) {
        int[] digits = Arrays.stream(numberString.split("")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                digits[i] = digits[i] * 2;
            }
        }

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 9) {
                digits[i] -= 9;
            }
            sum += digits[i];
        }

        return (int) getCeiling(sum) - sum;
    }

    public double getCeiling(double number){
        return Math.ceil(number / 10) * 10;
    }

    private String generatePIN() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(9999) + 1);
    }

    private boolean checkCardNumberUniqueness(String cardNumber) {
        return !cards.contains(cardNumber);
    }

    private Customer findCustomer(String cardNumber, String pinNumber) {
        for (Customer customer : customerList) {
            if (customer.getCardNumber().equals(cardNumber) && customer.getPinNumber().equals(pinNumber)) {
                return customer;
            }
        }
        return null;
    }
}