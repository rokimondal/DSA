public class Search {
    public static int linearSearch(int array[], int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int array[], int key) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == key) {
                return mid;
            }

            if (key < array[mid]) {
                end = mid - 1;
            }

            if (key > array[mid]) {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        /*
         * int array[] = new int[5]; // by default every element of an array initialize
         * by 0
         */
        int arr[] = { 10, 20, 30, 40, 50 };
        System.out.println(binarySearch(arr, 60));
    }
}