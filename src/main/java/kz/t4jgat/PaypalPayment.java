package kz.t4jgat;

public class PaypalPayment implements PaymentStrategy{
    @Override
    public String paymentProcess(double amount) {
        return "\n===Paid $" + amount + " with PayPal===";
    }
}
