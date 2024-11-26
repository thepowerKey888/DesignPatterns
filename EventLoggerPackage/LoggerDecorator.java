package EventLoggerPackage;

import java.util.List;

public abstract class LoggerDecorator implements Logger{

    protected Logger logger;

    public LoggerDecorator(Logger logger) {
        this.logger = logger;
    }

    //user story 1: Consistent logging through decoration
    @Override
    public synchronized void log(String message, LogLevel level) {
        logger.log(message, level);
    }

    //user story 3: Retrieve history of logged messages
    @Override
    public synchronized List<String> getLogHistory() {
        return logger.getLogHistory();
    }

    @Override
    public synchronized void flush() {
        logger.flush();
    }
}
