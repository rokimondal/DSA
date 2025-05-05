public class StairCaseSearch {
    public static boolean stairCaseSearch(int matrix[][], int key) {
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == key) {
                System.out.println("Found at : " + "( " + row + ", " + col + " )");
                return true;
            } else if (matrix[row][col] > key) {
                row--;
            } else {
                col++;
            }
        }
        System.out.println(key + " Not found");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 } };
        stairCaseSearch(matrix, 7);
    }
}
