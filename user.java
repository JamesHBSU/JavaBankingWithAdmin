import java.io.Serializable;

public abstract class User implements HasMenu, Serializable {

    String userName;
    String pin;

    boolean login() {
        System.out.print("Enter username: ");
        String enteredName = CheckingAccount.INPUT.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = CheckingAccount.INPUT.nextLine();

        return login(enteredName, enteredPin);
    }//end login

    boolean login(String userName, String pin) {
        if (this.userName.equals(userName)
                && this.pin.equals(pin)) {
            return true;
        }
        else {
            System.out.println("Invalid username or PIN.");
            return false;
        }
    }//end login

    void setUserName(String userName) {
        this.userName = userName;
    }//end setUserName

    String getUserName() {
        return userName;
    }//end getUserName

    void setPin(String pin) {
        this.pin = pin;
    }//end setPin

    String getPin() {
        return pin;
    }//end getPin

    abstract String getReport();
}//end User
