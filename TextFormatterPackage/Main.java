package TextFormatterPackage;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> data = new ArrayList<>();
        data.add("Some text.");
        data.add("Really cool text.");
        data.add("Super Duper!");
        data.add("Yeah dawg.");
        data.add("Diet Coke is the best drink.");

        TextFile file = new TextFile(data);

    }
}
