package NotificationsSystemPackage;

public class PushNotification extends NotificationDecorator{

    public PushNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Push notification: " + message);
        NotificationHistory.getInstance().addHistory("Push");
    }

    private void sendPushNotification(String message) {
        System.out.println("Sending Push notification: " + message);
    }
}
