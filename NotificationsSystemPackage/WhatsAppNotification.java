package NotificationsSystemPackage;

public class WhatsAppNotification extends NotificationDecorator {

    //user story 6 (example of an administrator adding another channel)
    public WhatsAppNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendWhatsAppMessage(message);
    }

    private void sendWhatsAppMessage(String message) {
        System.out.println("Sending WhatsApp notification: " + message);
    }
}