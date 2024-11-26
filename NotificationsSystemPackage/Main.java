package NotificationsSystemPackage;

public class Main {

    public static void main(String[] args){

        //user story 1
        Notification basicNotification = new BasicNotification();
        basicNotification.send("System update: Your app has a new feature!");
    }
}
