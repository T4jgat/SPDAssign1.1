# Singleton Pattern
The Singleton design pattern is a creational design pattern that ensures a class has only one instance while providing a global point of access to that instance. Its primary use case is to control the instantiation of a class so that there is a single, globally accessible instance of that class throughout the lifetime of an application.

Use Case:
- We used a singleton to create a single instance of PaymentProcessor, because there cannot be several payment systems
```java
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

```

# Strategy Pattern
The Strategy design pattern is a behavioral design pattern that defines a family of interchangeable algorithms, encapsulates each one, and makes them interchangeable. It allows the client to choose the appropriate algorithm dynamically at runtime, without altering the code that uses these algorithms.

Use case:
- We used a strategy pattern to dynamically change payment methods when using the program

### PaymentStrategy Interface
```java
public interface PaymentStrategy {
    String paymentProcess(double amount);
}
```

## PaymentStrategy implementations
### CardPayment
```java
public class CardPayment implements PaymentStrategy {
    @Override
    public String paymentProcess(double amount) {
        return "\n===Paid $" + amount + " with Card===";
    }
}
```
### PaypalPayment
```java
public class PaypalPayment implements PaymentStrategy{
    @Override
    public String paymentProcess(double amount) {
        return "\n===Paid $" + amount + " with PayPal===";
    }
}
```

# How to run?
clone this repo to your **Intellij Idea environment** and run `Main.java`
```shell
git clone https://github.com/T4jgat/SPDAssign1.1.git
```

# Any additional information or insights
Along the way we learned some things about multithreading in java