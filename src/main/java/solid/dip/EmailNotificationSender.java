package solid.dip;

public class EmailNotificationSender implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("Sending notification via Email");
    }
}
