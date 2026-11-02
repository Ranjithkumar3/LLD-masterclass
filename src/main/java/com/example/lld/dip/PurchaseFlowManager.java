package com.example.lld.dip;

public class PurchaseFlowManager {
    private final NotificationSender notificationSender;
    private final PaymentProcessor paymentProcessor;

    public PurchaseFlowManager(NotificationSender notificationSender, PaymentProcessor paymentProcessor) {
        this.notificationSender = notificationSender;
        this.paymentProcessor = paymentProcessor;
    }

    public void purchaseFlow() {
        paymentProcessor.processPayment();
        notificationSender.sendNotification();
    }
}
