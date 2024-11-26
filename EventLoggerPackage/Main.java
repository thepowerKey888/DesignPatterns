package EventLoggerPackage;

public class Main {

    public static void main(String[] args) {
        //user story 1: Centralized logger instance
        Logger basicLogger = new BasicLogger();

        //user story 4: Log to console
        Logger consoleLogger = new ConsoleLoggerDecorator(basicLogger);

        //log to console & file
        Logger fileLogger = new FileLoggerDecorator(consoleLogger, "app.log");

        //user story 2: Log messages with different levels
        fileLogger.log("Application started", LogLevel.INFO);
        fileLogger.log("Debugging the system", LogLevel.DEBUG);
        fileLogger.log("An error occurred", LogLevel.ERROR);

        //user story 3: Retrieve and review log history
        System.out.println("\nLog History:");
        for (String log : fileLogger.getLogHistory()) {
            System.out.println(log);
        }

        fileLogger.flush();
    }
}
