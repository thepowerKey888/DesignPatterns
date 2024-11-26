package NotificationsSystemPackage;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

       
        Notification basicNotification = new BasicNotification();

        //user story 5
        NotificationPreferences preferences = new NotificationPreferences();
        System.out.println("Customize your notifications by entering one notification channel at a time when prompted then press ENTER.\nType 'done' and press ENTER when finished.");
        while (true) {
            System.out.print("Select channel (SMS, Email, Slack): ");
            String channel = scanner.nextLine();
            if (channel.equalsIgnoreCase("done")) {
                break;
            }
            preferences.selectChannel(channel);
        }

        Notification customizedNotification = preferences.configure(basicNotification);
        customizedNotification.send("System update: Your app has a new feature!");

        scanner.close();
    }
    }

