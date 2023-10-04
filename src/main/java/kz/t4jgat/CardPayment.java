package kz.t4jgat;

public class CardPayment implements PaymentStrategy{
    @Override
    public String paymentProcess(double amount) {
        return "\n===Paid $" + amount + " with Card===";
    }
}
