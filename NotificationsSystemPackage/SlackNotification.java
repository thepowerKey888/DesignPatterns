package NotificationsSystemPackage;

public class SlackNotification extends NotificationDecorator{

    //user story 4
    public SlackNotification(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack notification: " + message);
    }
}
