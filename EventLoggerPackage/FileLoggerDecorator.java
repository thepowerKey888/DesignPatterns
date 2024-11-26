package EventLoggerPackage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;


class FileLoggerDecorator extends LoggerDecorator {
    private String filename;
    private String archiveDirectory = "archives/"; //stores archived logs

    public FileLoggerDecorator(Logger logger, String filename) {
        super(logger);
        this.filename = filename;
        this.archiveDirectory = "archives/"; //archive directory path
        new File(archiveDirectory).mkdirs(); //creates an archive folder if it doesn't exist
    }

    @Override
    public synchronized void log(String message, LogLevel level) {
        super.log(message, level); //log message to decorated logger

        //writes message to log file
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(level.name() + ": " + message + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    //user story 7: archive the current log file
    public synchronized void archiveLogs() {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String archiveFilename = archiveDirectory + "log_" + timestamp + ".txt";

        try {

            File currentLog = new File(filename);
            if (currentLog.exists()) {
                FileWriter archiveWriter = new FileWriter(archiveFilename);
                List<String> logHistory = this.getLogHistory();

                //write log history to the archive file
                for (String log : logHistory) {
                    archiveWriter.write(log + "\n");
                }
                archiveWriter.close();

                //clear the og log file
                currentLog.delete();
                System.out.println("Logs archived to: " + archiveFilename);
            }
        } catch (IOException e) {
            System.err.println("Error archiving logs: " + e.getMessage());
        }
    }

    //periodic archiving
    public synchronized void schedulePeriodicArchiving(long intervalInMillis) {
        new java.util.Timer().scheduleAtFixedRate(new java.util.TimerTask() {
            @Override
            public void run() {
                archiveLogs(); //archive logs every intervalInMillis
            }
        }, 0, intervalInMillis);
    }
}
