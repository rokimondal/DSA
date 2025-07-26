public class HeapSort {
    private static void heapify(int arr[], int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < n && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < n && arr[right] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, n);
        }
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 8, 3, 1, 2 };
        heapSort(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
}
