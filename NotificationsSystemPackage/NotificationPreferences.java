package NotificationsSystemPackage;
import java.util.ArrayList;
import java.util.List;

public class NotificationPreferences {

    //user story 5
    private List<String> selectedChannels = new ArrayList<>();

    public void selectChannel(String channel) {
        selectedChannels.add(channel);
    }

    public Notification configure(Notification baseNotification) {
        Notification decoratedNotification = baseNotification;

        for (String channel : selectedChannels) {
            switch (channel.toLowerCase()) {
                case "sms":
                    decoratedNotification = new SMSNotification(decoratedNotification);
                    break;
                case "email":
                    decoratedNotification = new EmailNotification(decoratedNotification);
                    break;
                case "slack":
                    decoratedNotification = new SlackNotification(decoratedNotification);
                    break;
                case "whatsapp":
                    decoratedNotification = new WhatsAppNotification(decoratedNotification);
                    break;
                default:
                    System.out.println("Unknown channel: " + channel);
            }
        }
        return decoratedNotification;
    }
}
