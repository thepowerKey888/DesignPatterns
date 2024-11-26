package EventLoggerPackage;

import java.util.ArrayList;
import java.util.List;
public class Logger {

    //user story 1
    private static Logger instance;

    //user story 3
    private List<String> logHistory;
    private Logger() {
        logHistory = new ArrayList<>();
    }

    //get the single instance of the Logger
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    //log messages
    public void log(String message) {
        String logMessage = "[LOG] " + message;
        logHistory.add(logMessage); //user story 3
        System.out.println(logMessage);
    }

    //user story 2
    //log messages with different severity levels
    public void log(String severity, String message) {
        String logMessage = "[" + severity.toUpperCase() + "] " + message;
        logHistory.add(logMessage);
        System.out.println(logMessage);
    }

    //retrieve the history of logged messages
    public List<String> getLogHistory() {
        return new ArrayList<>(logHistory);
    }
}
