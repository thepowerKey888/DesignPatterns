package NotificationsSystemPackage;
import java.util.ArrayList;
import java.util.List;
class NotificationHistory {

    //user story 9
    private static final NotificationHistory INSTANCE = new NotificationHistory();
    private List<String> history = new ArrayList<>();

    private NotificationHistory() {}

    public static NotificationHistory getInstance() {
        return INSTANCE;
    }

    //add entry to the history log
    public void addHistory(String channel) {
        history.add("Notification sent via: " + channel);
    }

    //display history of notifications
    public void displayHistory() {
        System.out.println("\nNotification History:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }
}
