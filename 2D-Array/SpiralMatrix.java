import java.util.Scanner;

public class SpiralMatrix {
    public static void displaySpiral(int array[][]) {
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // printing top
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(array[startRow][i] + ", ");
            }

            // printing right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(array[i][endCol] + ", ");
            }

            // printing bottom
            for (int i = endCol - 1; i > startCol; i--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(array[endRow][i] + ", ");
            }

            // printing left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(array[i][startCol] + ", ");
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
    }

    public static void creation(int array[][]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = sc.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 } };
        displaySpiral(matrix);
    }

}
