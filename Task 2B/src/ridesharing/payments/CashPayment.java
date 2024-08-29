package ridesharing.payments;

public class CashPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " in cash.");
    }
}
