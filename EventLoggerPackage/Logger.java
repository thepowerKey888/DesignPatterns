package EventLoggerPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Logger {

    //user story 1
    private static Logger instance;
    //user story 3
    private List<String> logHistory;
    //user story 4
    private LogOutput logOutput;
    private static final String ARCHIVE_FILE_PATH = "log_archive.txt"; //archive file
    private static final long ARCHIVE_INTERVAL = 5; //archive logs every 5 sec
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private Logger() {
        logHistory = Collections.synchronizedList(new ArrayList<>());
        logOutput = new ConsoleLogOutput();

        //periodic log archiving every 5 seconds
        scheduler.scheduleAtFixedRate(this::archiveLogs, ARCHIVE_INTERVAL, ARCHIVE_INTERVAL, TimeUnit.SECONDS);

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

    //user story 9: get current timestamp
    private String getCurrentTimestamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());  // Get the current timestamp in the desired format
    }

    //user story 4: set a custom log output destination (if needed in the future)
    public void setLogOutput(LogOutput logOutput) {
        this.logOutput = logOutput;
    }

    //log messages
    public void log(String message) {
        log("LOG", message);
    }

    //user story 2 log messages with different severity levels
    public void log(String severity, String message) {
        String timestamp = getCurrentTimestamp();
        LogMessage logMessage = new LogMessage(timestamp, severity.toUpperCase(), message);
        logHistory.add(logMessage.getFormattedMessage());
        logOutput.write(logMessage.getFormattedMessage());
    }

    //retrieve the history of logged messages
    public List<String> getLogHistory() {
        return new ArrayList<>(logHistory);
    }

    //save the logs
    public void archiveLogs() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVE_FILE_PATH, true))) {
            for (String log : logHistory) {
                writer.write(log);
                writer.newLine();
            }
            // Clear the log history after archiving (optional)
            logHistory.clear();
            System.out.println("Logs archived successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method for on-demand log archiving
    public void archiveLogsOnDemand() {
        archiveLogs(); // Calls the same method for immediate archiving
    }
}
