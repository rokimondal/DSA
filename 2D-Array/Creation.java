import java.util.Scanner;

public class Creation {
    public static void display(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
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

    public static void searching(int array[][], int key) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == key) {
                    System.out.println("Element position: (" + i + ", " + j + ")");
                    return;
                }
            }
        }
        System.out.println("Element is not found.");
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];
        creation(matrix);
        display(matrix);
        System.out.println("Enter element to search: ");
        int key = sc.nextInt();
        searching(matrix, key);
    }
}