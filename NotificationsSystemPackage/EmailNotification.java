package NotificationsSystemPackage;

public class EmailNotification extends NotificationDecorator{

    //user story 3
    public EmailNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending email notification: " + message);
        NotificationHistory.getInstance().addHistory("Email");
    }

    private void sendEmail(String message) {
        System.out.println("Sending email notification: " + message);
    }
}
