package EventLoggerPackage;

public class ConsoleLoggerDecorator extends LoggerDecorator{

    public ConsoleLoggerDecorator(Logger logger) {
        super(logger);
    }

    @Override
    public synchronized void log(String message, LogLevel level) {
        super.log(message, level);

        System.out.println("Console Log: " + level.name() + ": " + message); // user story 4: Log to console
    }
}
