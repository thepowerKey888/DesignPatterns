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
        logOutput = new ConsoleLogOutput(); // Default to console output

        // Schedule periodic log archiving every 60 seconds
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
