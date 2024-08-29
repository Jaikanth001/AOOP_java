package Pack;

public class BankingOperations {
    public void viewBalance() {
        if (UserSession.getInstance().isLoggedIn()) {
            System.out.println(UserSession.getInstance().getUserName() + ", your balance is $1000.");
        } else {
            System.out.println("Please log in to view your balance.");
        }
    }

    public void deposit() {
        if (UserSession.getInstance().isLoggedIn()) {
            System.out.println(UserSession.getInstance().getUserName() + ", you deposited $500.");
        } else {
            System.out.println("Please log in to deposit.");
        }
    }

    public void withdraw() {
        if (UserSession.getInstance().isLoggedIn()) {
            System.out.println(UserSession.getInstance().getUserName() + ", you withdrew $200.");
        } else {
            System.out.println("Please log in to withdraw.");
        }
    }
}

