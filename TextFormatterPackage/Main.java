package TextFormatterPackage;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        ArrayList<String> data = new ArrayList<>();
        data.add("Some text.");
        data.add("Really cool text.");
        data.add("Super Duper!");
        data.add("Yeah dawg.");
        data.add("Diet Coke is the best drink.");

        TextFile file = new TextFile(data);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a formatting option:");
        System.out.println("0: Plain Text");
        System.out.println("1: HTML");
        System.out.println("2: Markdown");
        System.out.println("3: Custom");

        int option = scanner.nextInt();
        scanner.nextLine();
        //user story #4
        switch (option){
            case 0:
                file.setFormat(new PlainTextFormat());
                break;
            case 1:
                file.setFormat(new HTMLFormat());
                break;
            case 2:
                file.setFormat(new MarkdownFormat());
                break;
            case 3:
                System.out.println("Enter your custom tag: ");
                String customTag = scanner.nextLine();
                file.setFormat(new CustomFormat(customTag));
                break;
            default:
                file.setFormat(new PlainTextFormat());
        }

        file.printFormatted();
    }
}
