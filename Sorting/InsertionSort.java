public class InsertionSort {

    public static void insertionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int array[] = { 2, 5, 1, 8, 0, 3 };
        insertionSort(array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + ", ");
    }

}
