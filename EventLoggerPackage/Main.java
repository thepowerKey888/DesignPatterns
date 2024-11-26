package EventLoggerPackage;

public class Main {

    public static void main(String[] args) {

        //user story 1
        Logger logger = Logger.getInstance();

        //multiple threads to log messages
        Thread thread1 = new Thread(() -> {
            logger.log("Thread 1", "Logging from thread 1");
            logger.log("INFO", "This is an informational message from thread 1");
        });

        Thread thread2 = new Thread(() -> {
            logger.log("Thread 2", "Logging from thread 2");
            logger.log("ERROR", "An error occurred in thread 2");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


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
