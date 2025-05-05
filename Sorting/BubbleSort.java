public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            // boolean isSorted = true;
            int swaps = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // isSorted = false;
                    swaps++;
                }
            }
            if (swaps == 0) { // if(isSorted)
                return;
            }
        }
    }

    public static void main(String[] args) {
        int array[] = { 2, 5, 0, 8, 1, 3 };
        bubbleSort(array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + ", ");
    }
}
