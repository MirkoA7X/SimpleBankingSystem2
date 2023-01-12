package banking;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    private static boolean shouldContinue = true;

    public static void main(String[] args) {
        Bank bank = new Bank();

        while (shouldContinue) {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account" );
            System.out.println("0. Exit");
                    

            if (!scanner.hasNextInt()) {
                System.out.println("Incorrect input!\n" +
                        "Try again:\n");

            }
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case(1):
                    bank.addCustomer();
                    break;
                case(2):
                    Customer customer = bank.login();
                    loginMenu(customer);
                    break;
                case(0):
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Incorrect input!");
            }
        }
    }

    public static void loginMenu(Customer customer) {
        boolean continueLogin = true;

        while (continueLogin) {
            System.out.println("1. Balance\n" +
                    "2. Log out\n" +
                    "0. Exit\n");

            if (!scanner.hasNextInt()) {
                System.out.println("Incorrect input!\n" +
                        "Try again:\n");

            }
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case(1):
                    System.out.println("Balance: " + customer.getBalance());
                    break;
                case(2):
                    continueLogin = false;
                    break;
                case(0):
                    shouldContinue = false;
                default:
                    System.out.println("Incorrect input!");
            }
        }
    }
}