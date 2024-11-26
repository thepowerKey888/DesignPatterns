package EventLoggerPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Logger {

    //user story 1
    private static Logger instance;

    //user story 3
    private List<String> logHistory;

    //user story 4
    private LogOutput logOutput;
    private Logger() {
        logHistory = new ArrayList<>();
        logOutput = new ConsoleLogOutput();
    }

    //get the single instance of the Logger
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {  //ensure thread-safe instantiation
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    //user story 4: set a custom log output destination (if needed in the future)
    public void setLogOutput(LogOutput logOutput) {
        this.logOutput = logOutput;
    }

    //log messages
    public void log(String message) {
        String logMessage = "[LOG] " + message;
        logHistory.add(logMessage); //user story 3
        logOutput.write(logMessage);
    }

    //user story 2 log messages with different severity levels
    public void log(String severity, String message) {
        String logMessage = "[" + severity.toUpperCase() + "] " + message;
        logHistory.add(logMessage);
        logOutput.write(logMessage);
    }

    //retrieve the history of logged messages
    public List<String> getLogHistory() {
        return new ArrayList<>(logHistory);
    }
}
