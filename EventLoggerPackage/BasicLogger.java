package EventLoggerPackage;

import java.util.ArrayList;
import java.util.List;



class BasicLogger implements Logger {
    private List<String> logHistory;
    private LogDestination logDestination; //holds destination

    public BasicLogger() {
        this.logHistory = new ArrayList<>();
    }

    // user story 1: Centralized logging (basic logger)
    @Override
    public synchronized void log(String message, LogLevel level) {
        String logMessage = level.name() + ": " + message;
        logHistory.add(logMessage);

        //log to the specified destination
        if (logDestination != null) {
            logDestination.writeLog(message, level);
        } else {

            System.out.println(logMessage);
        }
    }

    // user story 3: Retrieve history of logged messages
    @Override
    public synchronized  List<String> getLogHistory() {
        return logHistory;
    }

    @Override
    public synchronized void flush() {
        logHistory.clear();
    }

    @Override
    public void setLogDestination(LogDestination destination) {
        this.logDestination = destination;
    }
}
