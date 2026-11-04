import org.junit.jupiter.api.Test;
import solid.dip.*;

public class DIPTest {
    @Test
    void testPurchaseFlow() {
        PurchaseFlowManager emailAndNetBanking = new PurchaseFlowManager(new EmailNotificationSender(), new NetBankingPaymentProcessor());
        emailAndNetBanking.purchaseFlow();

        PurchaseFlowManager smsAndUPI = new PurchaseFlowManager(new SMSNotificationSender(), new UPIPaymentProcessor());
        emailAndNetBanking.purchaseFlow();
    }
}
