package com.example.lld.diptest;

import com.example.lld.dip.*;
import org.junit.jupiter.api.Test;

public class PurchaseFlowTest {
    @Test
    void testPurchaseFlow() {
        PurchaseFlowManager emailAndNetBanking = new PurchaseFlowManager(new EmailNotificationSender(), new NetBankingPaymentProcessor());
        emailAndNetBanking.purchaseFlow();

        PurchaseFlowManager smsAndUPI = new PurchaseFlowManager(new SMSNotificationSender(), new UPIPaymentProcessor());
        emailAndNetBanking.purchaseFlow();
    }
}
