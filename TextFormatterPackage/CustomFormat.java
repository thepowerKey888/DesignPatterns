package TextFormatterPackage;
import java.util.ArrayList;
import java.util.ArrayList;

public class CustomFormat implements IFormat {

    private String customTag;

    // Constructor to accept the custom tag from the user
    public CustomFormat(String customTag) {
        this.customTag = customTag;
    }

    // Implement the format method from the IFormat interface
    @Override
    public void format(ArrayList<String> data) {
        // Use the custom tag for both the header and body formatting
        System.out.println(customTag + data.get(0) + customTag);  // For header

        for (int i = 1; i < data.size(); i++) {
            System.out.println(customTag + data.get(i) + customTag);  // For body
        }

        System.out.println("");  // Adding some space at the end
    }
}