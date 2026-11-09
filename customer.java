public class Customer extends User {

    CheckingAccount checking;
    SavingsAccount savings;

    // Constructor with account balances
    public Customer(String userName, String pin,
                    double checkingBalance,
                    double savingsBalance,
                    double interestRate) {

        this.userName = userName;
        this.pin = pin;

        this.checking = new CheckingAccount(checkingBalance);
        this.savings = new SavingsAccount(savingsBalance, interestRate);

    }//end Customer constructor

    // Constructor with default account balances
    public Customer(String userName, String pin) {

        this.userName = userName;
        this.pin = pin;

        this.checking = new CheckingAccount(0);
        this.savings = new SavingsAccount(0, 0);

    }//end Customer constructor

    // Default customer
    public Customer() {
        this("Alice", "0000");
    }//end Customer constructor

    @Override
    public String menu() {
        return "0. Exit\n"
             + "1. Checking Account\n"
             + "2. Savings Account\n"
             + "3. Change PIN";
    }//end menu

    void changePin() {
        System.out.print("Enter new PIN: ");

        String newPin = CheckingAccount.INPUT.nextLine();

        setPin(newPin);

        System.out.println("PIN successfully changed.");
    }//end changePin

    @Override
    String getReport() {
        return "Customer: " + userName
             + "\nChecking Balance: " + checking.getBalanceString()
             + "\nSavings Balance: " + savings.getBalanceString()
             + "\nInterest Rate: " + savings.getInterestRate();
    }//end getReport

    @Override
    public void start() {

        // Login
        while (!login()) {
            System.out.println("Please try again.");
        }

        boolean running = true;

        while (running) {
            System.out.println(menu());
            System.out.print("Enter your choice: ");

            int choice = CheckingAccount.INPUT.nextInt();
            CheckingAccount.INPUT.nextLine();

            if (choice == 0) {
                running = false;
            }
            else if (choice == 1) {
                checking.start();
            }
            else if (choice == 2) {
                savings.start();
            }
            else if (choice == 3) {
                changePin();
            }
            else {
                System.out.println("Invalid choice.");
            }
        }//end while
    }//end start
}//end Customer
