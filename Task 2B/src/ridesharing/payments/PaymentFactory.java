package ridesharing.payments;

public class PaymentFactory {
    public PaymentMethod createPaymentMethod(String type) {
        switch (type.toLowerCase()) {
            case "creditcard":
                return new CreditCardPayment();
            case "paypal":
                return new PayPalPayment();
            case "cash":
                return new CashPayment();
            default:
                throw new IllegalArgumentException("Unknown payment method.");
        }
    }
}
