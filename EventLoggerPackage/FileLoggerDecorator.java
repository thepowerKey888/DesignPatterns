package EventLoggerPackage;
import java.io.FileWriter;
import java.io.IOException;



class FileLoggerDecorator extends LoggerDecorator {
    private String filename;

    public FileLoggerDecorator(Logger logger, String filename) {
        super(logger);
        this.filename = filename;
    }

    @Override
    public void log(String message, LogLevel level) {
        super.log(message, level);
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(level.name() + ": " + message + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
