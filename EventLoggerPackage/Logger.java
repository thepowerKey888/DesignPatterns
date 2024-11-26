package EventLoggerPackage;

public class Logger {

    //user story 1

    private static Logger instance;
    private Logger() {

    }

    //get the single instance of the Logger
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    //log messages (consistent logging)
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }


}
