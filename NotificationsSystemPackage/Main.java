package NotificationsSystemPackage;

public class Main {

    public static void main(String[] args){

        //user story 1
        Notification basicNotification = new BasicNotification();
        basicNotification.send("System update: Your app has a new feature!");

        //user story 2
        Notification smsNotification = new SMSNotification(basicNotification);
        smsNotification.send("System update: New security patch available!");

        //user story 3
        Notification emailNotification = new EmailNotification(basicNotification);
        emailNotification.send("System update: Your account settings have been updated!");

    }
}
