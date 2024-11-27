package NotificationsSystemPackage;
import java.util.ArrayList;
import java.util.List;

public class NotificationPreferences {

    //user story 5
    private List<String> selectedChannels = new ArrayList<>();

    public void selectChannel(String channel) {
        if (!selectedChannels.contains(channel)) {
            selectedChannels.add(channel);
            System.out.println(channel + " enabled.");
        } else {
            System.out.println(channel + " is already enabled.");
        }
    }

    public void deselectChannel(String channel) {
        if (selectedChannels.contains(channel)) {
            selectedChannels.remove(channel);
            System.out.println(channel + " disabled.");
        } else {
            System.out.println(channel + " is not enabled.");
        }
    }
    public List<Notification> configure(Notification baseNotification) {
        List<Notification> decoratedNotifications = new ArrayList<>();

        //apply the corresponding decorator
        for (String channel : selectedChannels) {
            Notification decoratedNotification = NotificationFactory.createNotification(channel, baseNotification);
            decoratedNotifications.add(decoratedNotification);
        }

        return decoratedNotifications;
    }


}
