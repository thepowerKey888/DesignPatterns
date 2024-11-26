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
            System.out.print("Select channel (SMS, Email, Slack, WhatsApp, Push): ");
            String channel = scanner.nextLine();
            if (channel.equalsIgnoreCase("done")) {
                break;
            }
            preferences.selectChannel(channel);
        }

        System.out.println("Sending notifications through selected channels:");
        //Notification customizedNotification = preferences.configure(basicNotification);
        //customizedNotification.send("System update: Your app has a new feature!");
        //customizedNotification.send("System request: Apple wallet needs your attention!");


        List<Notification> customizedNotifications = preferences.configure(basicNotification);

        System.out.println("Sending notifications through selected channels:");
        for (Notification notification : customizedNotifications) {
            notification.send("System update: Your app has a new feature!");
        }

        scanner.close();
    }
}

