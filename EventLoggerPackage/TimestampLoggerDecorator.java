package EventLoggerPackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampLoggerDecorator extends LoggerDecorator {

    //user story 8
    public TimestampLoggerDecorator(Logger logger) {
        super(logger);
    }

    @Override
    public synchronized void log(String message, LogLevel level) {

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logMessageWithTimestamp = "[" + timestamp + "] " + message;

        //send message with timestamp to decorated logger
        super.log(logMessageWithTimestamp, level);
    }
}

