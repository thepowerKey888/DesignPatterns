package NotificationsSystemPackage;

public class SMSNotification extends NotificationDecorator{

    //user story 2
    public SMSNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}
