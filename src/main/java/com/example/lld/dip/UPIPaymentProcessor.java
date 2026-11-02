package com.example.lld.dip;

public class UPIPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        System.out.println("Payment via UPI");
    }
}
