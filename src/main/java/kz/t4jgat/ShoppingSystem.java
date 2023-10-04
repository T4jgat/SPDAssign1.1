package kz.t4jgat;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ShoppingSystem {

    PaymentProcessor paymentProcessor = PaymentProcessor.getInstance();

    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    private List<Product> shoppingCart = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("0.00");

    private void addProduct(String name, double price, int qty) {
        shoppingCart.add(new Product(name, price, qty));
        System.out.println("===Product '" + name + "' added!====");
    }

    private double calculatingTotalPrice() {
        double generalSum = 0, qtySum;
        for (int i = 0; i < shoppingCart.size(); i++) {
            qtySum = shoppingCart.get(i).getPrice() * shoppingCart.get(i).getQty();
            generalSum = generalSum + qtySum;
        }
        return generalSum;
    }



    private void viewContent() {
        Product product;
        int count = 0;
        System.out.println("\n--------------Shopping cart--------------");
        for (int i = 0; i < shoppingCart.size(); i++) {
            product = shoppingCart.get(i);
            System.out.println(
                    ++count + "\t" + product.getName() + "\t$" + product.getPrice() + "\t" + product.getQty() + "pc."
            );
        }

        System.out.println("-----------------------------------------");
        System.out.println("Total price: $" + df.format(calculatingTotalPrice()));
        System.out.println("-----------------------------------------");
    }


    public void ShoppingCLI() {
        String action = "-", name;
        double price;
        int qty, paymentStrategySelection;

        while (!action.equals("e")) {
            System.out.print("""
                    \n[1] Add product
                    [2] View the cart's content
                    [3] Choose payment strategy
                    [4] Complete the checkout
                    [e] Exit
                    >>\s""");
            action = sc.next();
            switch (action) {
                case "1" -> {
                    System.out.print("Name: ");
                    name = sc.next();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    qty = sc.nextInt();
                    addProduct(name, price, qty);
                    break;
                }
                case "2" -> {
                    viewContent();
                    break;
                }
                case "3" -> {
                    System.out.print("""
                            \nChoose your payment strategy:
                            [1] Card
                            [2] Paypal
                            >>\s""");
                    paymentStrategySelection = sc.nextInt();
                    paymentProcessor.selectPaymentStrategy(paymentStrategySelection);
                    break;
                }
                case "4" -> {
                    paymentProcessor.executePayment(calculatingTotalPrice());
                    break;
                }
                case "e" -> {
                    System.out.println("Exit...");
                    break;
                }
                default -> System.out.println("\nUnexpected value!");

            }
        }
    }
}


