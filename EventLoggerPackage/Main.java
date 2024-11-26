package EventLoggerPackage;

public class Main {

    public static void main(String[] args) {

        //user story 1
        Logger logger = Logger.getInstance();

        //user story 2
        logger.log("Application started");
        logger.log("INFO", "This is a message");
        logger.log("DEBUG", "There's a bug in the code!");
        logger.log("ERROR", "An error has occurred");

        System.out.println("\nLog History:");
        for (String log : logger.getLogHistory()) {
            System.out.println(log);
        }

    }
}
