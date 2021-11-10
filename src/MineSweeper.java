import java.util.Random;

public class MineSweeper {
    static String[][] mineSweeperMap;
    static String[][] mineMap;
    static int totalMine;

    public void createMineSweeper(int rows, int columns){
        MineSweeper msObj = new MineSweeper();
        Random rand = new Random();

        this.mineSweeperMap = new String[rows][columns];
        this.mineMap = new String[rows][columns];
        this.totalMine =  (rows * columns) / 4;

        int i = 0;
        while (i < this.totalMine){
            int randomRow = rand.nextInt(totalMine + 1);
            int randomColumn = rand.nextInt(totalMine + 1);

           if (msObj.mineMap[randomRow][randomColumn] == null){
                this.mineSweeperMap[randomRow][randomColumn] = "*";
                this.mineMap[randomRow][randomColumn] = "*";
                i++;
            }

        }

        printArray(this.mineMap);
    }

    public static void printArray(String[][] arr){

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("\n");
        }
    }


}
