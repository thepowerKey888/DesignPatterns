package EventLoggerPackage;
import java.util.List;
public class RemoteLogDestination implements LogDestination{

    private String serverUrl;

    public RemoteLogDestination(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Override
    public void writeLog(String message, LogLevel level) {
        // Simulate remote logging (e.g., sending HTTP requests)
        System.out.println("Sending to remote server (" + serverUrl + "): " + level.name() + ": " + message);
    }


}
