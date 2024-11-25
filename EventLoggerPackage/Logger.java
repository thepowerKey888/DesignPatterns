package EventLoggerPackage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

    //User Story 1 As a developer, I want a single, centralized logger instance,
    // so that logging is consistent across the application
    public class Logger {

        private static Logger instance;
        private List<String> logHistory = new ArrayList<>();
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        private Logger() {
        }

        //get the singleton instance of Logger
        public static synchronized Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        //log messages
        public void log(String message) {
            String timestamp = dateFormat.format(new Date());
            String formattedMessage = timestamp + " - " + message;
            logHistory.add(formattedMessage);
            System.out.println(formattedMessage);
        }

        //retrieve log history
        public List<String> getLogHistory() {
            return logHistory;
        }
    }

