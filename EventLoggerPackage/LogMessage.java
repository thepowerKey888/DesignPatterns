package EventLoggerPackage;

public class LogMessage {

    private String timestamp;
    private String severity;
    private String message;

    public LogMessage(String timestamp, String severity, String message) {
        this.timestamp = timestamp;
        this.severity = severity;
        this.message = message;
    }

    public String getFormattedMessage() {
        return String.format("[%s] [%s] %s", timestamp, severity, message);
    }
}
