package kz.t4jgat;

public class PaymentProcessor {
    private static PaymentProcessor instance;
    private PaymentStrategy paymentStrategy;

    private PaymentProcessor() {
        this.paymentStrategy = null;
    }

    // Singleton method
    public static PaymentProcessor getInstance() {
        if (instance == null) {
            synchronized (PaymentProcessor.class) {
                if (instance == null) {
                    instance = new PaymentProcessor();
                }
            }
        }
        return instance;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void selectPaymentStrategy(int selection) {
        if (selection == 1) {
            this.setPaymentStrategy(new CardPayment());
            System.out.println("\n===Set Card Payment===");
        }
        if (selection == 2) {
            this.setPaymentStrategy(new PaypalPayment());
            System.out.println("\n===Set Paypal Payment===");
        }
    }

    public void executePayment(double amount) {
        System.out.println(paymentStrategy.paymentProcess(amount));
    }


}
