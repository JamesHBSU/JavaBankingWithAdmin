public class SavingsAccount extends CheckingAccount {

    double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }//end SavingsAccount constructor

    double getInterestRate() {
        return interestRate;
    }//end getInterestRate

    void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }//end setInterestRate

    double calcInterest() {
        return balance * interestRate;
    }//end calcInterest

    void applyInterest() {
        double interest = calcInterest();

        balance += interest;

        System.out.println("Interest applied: " + interest);
    }//end applyInterest
}//end SavingsAccount
