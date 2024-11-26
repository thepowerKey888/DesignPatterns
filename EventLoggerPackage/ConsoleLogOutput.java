package EventLoggerPackage;

public class ConsoleLogOutput implements LogOutput{

    //user story 4
    public void write(String message) {
        System.out.println(message); //writes the log to the console
    }
}
