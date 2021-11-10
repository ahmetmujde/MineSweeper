import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MineSweeper ms = new MineSweeper();

        System.out.println("Do you play MineSweeper ? (Yes: y, No: n)");
        char answer = scanner.next().charAt(0);

        if (String.valueOf(answer).equals("y") || String.valueOf(answer).equals("Y")){
            System.out.println("Please enter the row's value");
            int rows = scanner.nextInt();
            System.out.println("Please enter the column's value");
            int column = scanner.nextInt();

            ms.createMineSweeper(rows,column);

        } else{
            System.out.println("Okay Good Bye!");
        }



    }
}
