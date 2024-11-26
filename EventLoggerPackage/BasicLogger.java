package EventLoggerPackage;

import java.util.ArrayList;
import java.util.List;



class BasicLogger implements Logger {
    private List<String> logHistory;

    public BasicLogger() {
        this.logHistory = new ArrayList<>();
    }

    // user story 1: Centralized logging (basic logger)
    @Override
    public void log(String message, LogLevel level) {
        String logMessage = level.name() + ": " + message;
        logHistory.add(logMessage);

        System.out.println(logMessage);
    }

    // user story 3: Retrieve history of logged messages
    @Override
    public List<String> getLogHistory() {
        return logHistory;
    }

    @Override
    public void flush() {
        logHistory.clear();
    }
}
