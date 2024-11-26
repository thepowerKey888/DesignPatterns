package EventLoggerPackage;

import java.util.List;
public interface Logger {


        void log(String message, LogLevel level);
        //user story 3: Retrieve history of logged messages
        List<String> getLogHistory();
        void flush();

}
