package EventLoggerPackage;
import java.io.FileWriter;
import java.io.IOException;
public class FileLogDestination implements LogDestination {
    private String filename;

    public FileLogDestination(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeLog(String message, LogLevel level) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(level.name() + ": " + message + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
