package com.example.lld.dip;

public class SMSNotificationSender implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("Sending notification via SMS");
    }
}
