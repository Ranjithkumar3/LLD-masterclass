package solid.dip;

public class NetBankingPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        System.out.println("Payment via Net Banking");
    }
}
