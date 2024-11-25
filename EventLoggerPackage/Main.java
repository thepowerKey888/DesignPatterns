package EventLoggerPackage;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();


        logger.log("Application started.", "INFO");
        logger.log("Processing data...", "DEBUG");
        logger.log("An error occurred.", "ERROR");


        System.out.println("Log History:");
        for (String log : logger.getLogHistory()) {
            System.out.println(log);
        }
    }
}