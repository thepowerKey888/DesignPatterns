package TextFormatterPackage;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;
public class TextFile {

    private ArrayList<String> fileContent;
    private IFormat format;
    public TextFile(){
        fileContent = new ArrayList<>();
    }

    public void setFormat(IFormat format){
        this.format = format;
    }

    public TextFile(ArrayList<String> data){

        fileContent = data;
    }

    public void printFormatted(){
        format.format(fileContent);
    }

    //User Story #1: plain txt file
    public void printPlainText(){

        //prints txt in plain text
        for(int i = 0; i < fileContent.size(); i++){
            System.out.println(fileContent.get(i));
        }
    }

    //User Story: #2
    public void printHTML(){

        System.out.println("<html dir = \"ltr\" lang=\"en\">");
        System.out.println("<head>");
        for(int i = 0; i < fileContent.size(); i++){
            System.out.println("<text=" + fileContent.get(i) + ">");
        }

        System.out.println("</head>");
        System.out.println("</html>");
    }


}
