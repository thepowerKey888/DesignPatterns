package EventLoggerPackage;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();


        logger.log("Application started.");
        logger.log("Processing data...");
        logger.log("Application finished.");

        
        System.out.println("Log History:");
        for (String log : logger.getLogHistory()) {
            System.out.println(log);
        }
    }
}