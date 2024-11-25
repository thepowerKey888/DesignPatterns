package TextFormatterPackage;
import java.util.ArrayList;
import java.util.Random;

public class MarkdownFormat implements IFormat{


    @Override
    public void format(ArrayList<String> data){

        String[] options = {"**", "***", "<sub>","~~", "_"};

        Random rng = new Random();
        rng.nextInt();

        System.out.println("#" + data.get(0)); //header

        for(int i = 1; i < data.size(); i++){
            int number = rng.nextInt(options.length); //setting bound to length of options array
            String option = options[number];
            System.out.println(option + data.get(i) + option);
        }

        System.out.println("");
        System.out.println("");
    }

}
