import java.util.Random;

public class MineSweeper {
    static String[][] mineSweeperMap;
    static String[][] mineMap;
    static int totalMine;
    static int countGameStep = 0;

    public static void createMineSweeper(int rows, int columns){
        Random rand = new Random();

        mineSweeperMap = new String[rows][columns];
        mineMap = new String[rows][columns];

        totalMine =  (rows * columns) / 4;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mineSweeperMap[i][j] = "-";
                mineMap[i][j] = "-";
            }
        }

        int i = 0;
        while (i < totalMine){
            int randomRow = rand.nextInt(rows);
            int randomColumn = rand.nextInt(columns);

            if (!("*".equals(mineMap[randomRow][randomColumn]))){
                mineMap[randomRow][randomColumn] = "*";
                i++;
            }

        }
    }

    public static void printArray(String[][] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }

    public boolean checkMine(int row, int column){
        return "*".equals(mineMap[row][column]);
    }

    public void countTheMine(int row, int column){

        int sum = 0;
        int lowerRow = row;
        int upperRow = row;
        int lowerColumn = column;
        int upperColumn = column;

        if (row != 0){
            lowerRow--;
        }

        if (column != 0){
            lowerColumn--;
        }

        if (row + 1 < mineMap[0].length){
            upperRow++;
        }

        if (column + 1 < mineMap[1].length){
            upperColumn++;
        }

        for (int i = lowerRow; i <= upperRow; i++) {
            for (int j = lowerColumn; j <= upperColumn; j++) {
                if (mineMap[i][j] != null){
                    if ("*".equals(mineMap[i][j])){
                        sum ++;
                    }
                }
            }
        }

        mineSweeperMap[row][column] = String.valueOf(sum);
    }

    public static void  gameStep(int row, int column){
        if (("-".equals(mineSweeperMap[row][column]))){
            countGameStep++;
        }
    }


    public static boolean   isGameContinue(int rows, int columns){
        return countGameStep < (rows * columns) - totalMine;
    }

}
