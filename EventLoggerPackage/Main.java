package EventLoggerPackage;

public class Main {

    public static void main(String[] args) {
        //user story 1: Centralized logger instance
        Logger basicLogger = new BasicLogger();

        //user story8 dynamically set output destination (console, file, or remote)
        LogDestination consoleDestination = new ConsoleLogDestination(); // Logs to console
        LogDestination fileDestination = new FileLogDestination("app.log"); // Logs to file
        LogDestination remoteDestination = new RemoteLogDestination("http://remote-log-server.com"); // Logs to remote

        //user story 8
        Logger timestampLogger = new TimestampLoggerDecorator(basicLogger);

        //user story 4: Log to console
        Logger consoleLogger = new ConsoleLoggerDecorator(basicLogger);
        Logger fileLogger = new FileLoggerDecorator(consoleLogger, "app.log");

        //set the log destination to the console
        consoleLogger.setLogDestination(consoleDestination);
        fileLogger.setLogDestination(fileDestination); // Set destination to file

        //user story 2: Log messages with different levels
        fileLogger.log("Application started", LogLevel.INFO);
        fileLogger.log("Debugging the system", LogLevel.DEBUG);
        fileLogger.log("An error occurred", LogLevel.ERROR);

        //user story 7
        FileLoggerDecorator fileLoggerDecorator = (FileLoggerDecorator) fileLogger;
        fileLoggerDecorator.archiveLogs();

        //user story 3: Retrieve and review log history
        System.out.println("\nLog History:");
        for (String log : fileLogger.getLogHistory()) {
            System.out.println(log);
        }

        //archive every 10 min
        fileLoggerDecorator.schedulePeriodicArchiving(600000);
        fileLogger.flush();

        //switches to remote logging (dynamically change the log destination)
        fileLogger.setLogDestination(remoteDestination); // Now sending logs to a remote server
        fileLogger.log("Critical error reported to remote server", LogLevel.ERROR);


    }
}
