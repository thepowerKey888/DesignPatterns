package TextFormatterPackage;

import java.util.ArrayList;

public class PlainTextFormat implements IFormat {

    @Override
    public void format(ArrayList<String> data){
        //prints txt in plain text
        for(int i = 0; i < data.size(); i++){
            System.out.println(data.get(i));
        }
    }
}
