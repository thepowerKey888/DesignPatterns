package EventLoggerPackage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FileLogOutput implements LogOutput {
    //user story 5
    private String filePath;

    public FileLogOutput(String filePath) {
        this.filePath = filePath;
    }

    //writes a log message to a file
    public void write(String message) {

        System.out.println("Writing to file: " + filePath + " -> " + message);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
