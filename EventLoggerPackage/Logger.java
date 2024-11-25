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

        //User Story 2: Logging messages with different severity levels
        public void log(String message, String severity) {
            String formattedMessage = formatMessage(message, severity);
            logHistory.add(formattedMessage);
            System.out.println(formattedMessage); // Default: Print to console
        }

        //helper method (formats log messages with severity and timestamp)
        private String formatMessage(String message, String severity) {
            String timestamp = dateFormat.format(new Date());
            return "[" + severity + "] " + timestamp + " - " + message;
        }

        //retrieve log history
        public List<String> getLogHistory() {
            return logHistory;
        }
    }

