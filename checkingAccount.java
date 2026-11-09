import java.util.Scanner;
import java.util.InputMismatchException;

public class CheckingAccount implements HasMenu {

    protected double balance;

    public static final Scanner INPUT = new Scanner(System.in);

    // Default constructor
    public CheckingAccount() {
        balance = 0;
    }//end CheckingAccount constructor

    // Constructor with starting balance
    public CheckingAccount(double balance) {
        this.balance = balance;
    }//end CheckingAccount constructor

    double getBalance() {
        return balance;
    }//end getBalance

    void setBalance(double balance) {
        this.balance = balance;
    }//end setBalance

    String getBalanceString() {
        return "Balance: " + balance;
    }//end getBalanceString

    void checkBalance() {
        System.out.println(getBalanceString());
    }//end checkBalance

    private double getDouble(String prompt) {
        System.out.print(prompt);

        try {
            double value = INPUT.nextDouble();
            INPUT.nextLine();

            if (value < 0) {
                throw new IllegalArgumentException(
                    "Error: Value cannot be negative."
                );
            }

            return value;

        } catch (InputMismatchException e) {
            INPUT.nextLine();
            System.out.println("Please enter a valid number.");
            return 0;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }//end getDouble

    void deposit() {
        double amount = getDouble("Enter deposit amount: ");

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }//end deposit

    void withdraw() {
        double amount = getDouble("Enter withdrawal amount: ");

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        }
        else if (amount > balance) {
            System.out.println("Insufficient funds.");
        }
    }//end withdraw

    @Override
    public String menu() {
        return "0. Exit\n"
             + "1. Check Balance\n"
             + "2. Deposit\n"
             + "3. Withdraw";
    }//end menu

    @Override
    public void start() {
        boolean running = true;

        while (running) {
            System.out.println(menu());
            System.out.print("Enter your choice: ");

            int choice = INPUT.nextInt();
            INPUT.nextLine();

            if (choice == 0) {
                running = false;
            }
            else if (choice == 1) {
                checkBalance();
            }
            else if (choice == 2) {
                deposit();
            }
            else if (choice == 3) {
                withdraw();
            }
            else {
                System.out.println("Invalid choice.");
            }
        }//end while
    }//end start
}//end CheckingAccount
