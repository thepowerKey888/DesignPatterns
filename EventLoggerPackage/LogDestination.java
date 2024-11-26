package EventLoggerPackage;

public interface LogDestination {
    void writeLog(String message, LogLevel level);
}
