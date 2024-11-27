package EventLoggerPackage;

public class RemoteLogOutput implements LogOutput{

    //user story 8
    private String serverUrl;

    public RemoteLogOutput(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Override
    public void write(String message) {

        System.out.println("Sending log to remote server at " + serverUrl + ": " + message);

    }
}
