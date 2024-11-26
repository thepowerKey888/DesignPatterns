package NotificationsSystemPackage;
import java.util.Scanner;
import java.util.List;
public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        Notification basicNotification = new BasicNotification();

        //user story 5 & 7
        NotificationPreferences preferences = new NotificationPreferences();

        System.out.println("Customize your notifications by entering one notification channel at a time when prompted then press ENTER.\nType 'done' and press ENTER when finished.");
        while (true) {
            System.out.print("Would you like to enable or disable a channel? (enable/disable): ");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Select channel (SMS, Email, Slack, WhatsApp, Push): ");
            String channel = scanner.nextLine();

            if (action.equalsIgnoreCase("enable")) {
                preferences.selectChannel(channel);
            } else if (action.equalsIgnoreCase("disable")) {
                preferences.deselectChannel(channel);
            } else {
                System.out.println("Invalid action. Please enter 'enable' or 'disable'.");
            }
        }

        List<Notification> customizedNotifications = preferences.configure(basicNotification);

        System.out.println("Sending notifications through selected channels:");
        for (Notification notification : customizedNotifications) {
            notification.send("System update: Your app has a new feature!");
        }

        NotificationHistory.getInstance().displayHistory();

        scanner.close();
    }
}

