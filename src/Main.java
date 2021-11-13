import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MineSweeper ms = new MineSweeper();

        int row;
        int column;

        System.out.println("Do you play MineSweeper ? (Yes: y, No: n)");
        char answer = scanner.next().charAt(0);

        if (String.valueOf(answer).equals("y") || String.valueOf(answer).equals("Y")){
            System.out.println("Please enter the row's value");
            int rows = scanner.nextInt();
            System.out.println("Please enter the column's value");
            int columns = scanner.nextInt();

            ms.createMineSweeper(rows,columns);
            ms.printArray(ms.mineSweeperMap);


            while (true){
                if(ms.isGameContinue(rows,columns)){
                    System.out.print("Enter the value of  x coordinate: ");
                    row = scanner.nextInt();

                    System.out.print("Enter the value of  y coordinate: ");
                    column = scanner.nextInt();
                    if (!(ms.checkMine(row, column))){
                        ms.gameStep(row,column);
                        ms.countTheMine(row,column);
                        ms.printArray(ms.mineSweeperMap);
                    } else{
                        System.out.println("Game Over :[ ");
                        ms.printArray(ms.mineMap);
                        break;
                    }
                } else{
                        System.out.println("Congratulations You Won The Game :] ");
                        ms.printArray(ms.mineMap);
                        break;
                }
            }

        } else{
            System.out.println("Okay Good Bye!");
        }



    }
}
