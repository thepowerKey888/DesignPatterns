package EventLoggerPackage;

public class Main {

    public static void main(String[] args) {

        //user story 1
        Logger logger = Logger.getInstance();
        System.out.println("Current working directory: " + System.getProperty("user.dir"));




        //put logger output to file for retaining logs
        logger.setLogOutput(new FileLogOutput("logs.txt"));
        //user story 2
        logger.log("WARN", "This is a warning message");
        logger.log("ERROR", "An error has occurred");

        System.out.println("\nLog History:");
        for (String log : logger.getLogHistory()) {
            System.out.println(log);
        }

    }
}
