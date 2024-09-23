package Pack;

public class Main {
    public static void main(String[] args) {
        UserSession session = UserSession.getInstance();
        BankingOperations operations = new BankingOperations();

        session.login("Alice");

        operations.viewBalance();
        operations.deposit();
        operations.withdraw();

        session.logout();
    }
}

