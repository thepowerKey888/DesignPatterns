package EventLoggerPackage;

public class ConsoleLogDestination implements LogDestination {

    @Override
    public void writeLog(String message, LogLevel level) {
        System.out.println(level.name() + ": " + message);
    }
}