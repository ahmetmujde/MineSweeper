import java.util.Random;

public class MineSweeper {
    static String[][] mineSweeperMap;
    static String[][] mineMap;
    static int totalMine;
    static int gameStep = 0;

    public static void createMineSweeper(int rows, int columns){
        Random rand = new Random();

        mineSweeperMap = new String[rows][columns];
        mineMap = new String[rows][columns];

        totalMine =  (rows * columns) / 4;


        for (int i = 0; i < mineSweeperMap[0].length; i++) {
            for (int j = 0; j < mineSweeperMap[1].length; j++) {
                mineSweeperMap[i][j] = "-";
                mineMap[i][j] = "-";
            }
        }


        int i = 0;
        while (i < totalMine){
            int randomRow = rand.nextInt(totalMine + 1);
            int randomColumn = rand.nextInt(totalMine + 1);

            if (!("*".equals(mineMap[randomRow][randomColumn]))){
                mineMap[randomRow][randomColumn] = "*";
                i++;
            }

        }

        printArray(mineSweeperMap);
        printArray(mineMap);
        System.out.println( mineMap[0].length);
        System.out.println( mineMap[1].length);
    }

    public static void printArray(String[][] arr){

        for (int i = 0; i < arr[0].length; i++) {
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

        gameStep++;
        mineSweeperMap[row][column] = String.valueOf(sum);

        printArray(mineSweeperMap);
    }

}
