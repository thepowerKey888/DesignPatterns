package NotificationsSystemPackage;

public class BasicNotification implements Notification {

    //user story 1
    @Override
    public void send(String message) {
        System.out.println("Sending basic notification: " + message);
    }
}
