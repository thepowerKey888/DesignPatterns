package EventLoggerPackage;

import java.util.List;

public abstract class LoggerDecorator implements Logger{

    protected Logger logger;
    protected LogDestination logDestination;

    public LoggerDecorator(Logger logger) {
        this.logger = logger;
    }

    //user story 1: Consistent logging through decoration
    @Override
    public void log(String message, LogLevel level) {
        logger.log(message, level); // Delegate to the wrapped logger
        if (logDestination != null) {
            logDestination.writeLog(message, level); // Write to the configured destination
        }
    }

    //user story 3: Retrieve history of logged messages
    @Override
    public List<String> getLogHistory() {
        return logger.getLogHistory();
    }

    @Override
    public synchronized void flush() {
        logger.flush();
    }

    @Override
    public void setLogDestination(LogDestination destination) {
        this.logDestination = destination; // Set the log destination dynamically
    }
}
