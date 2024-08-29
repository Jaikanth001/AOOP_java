package ridesharing;

import ridesharing.authentication.UserAuthentication;
import ridesharing.vehicles.Vehicle;
import ridesharing.vehicles.VehicleFactory;
import ridesharing.payments.PaymentFactory;
import ridesharing.payments.PaymentMethod;

public class Main {
    public static void main(String[] args) {
        UserAuthentication auth = UserAuthentication.getInstance();
        auth.login("Alice");

        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle = vehicleFactory.createVehicle("car");
        vehicle.ride();

        PaymentFactory paymentFactory = new PaymentFactory();
        PaymentMethod payment = paymentFactory.createPaymentMethod("creditcard");
        payment.pay(20.0);

        auth.logout();
    }
}
