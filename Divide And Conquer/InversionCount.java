public class InversionCount {
     public static int inversionCount(int arr[]) { //brute force approach
     int n = arr.length;
     int count = 0;
     for (int i = 0; i < n - 1; i++) {
     for (int j = i + 1; j < n; j++) {
     if (arr[i] > arr[j]) {
     count++;
     }
     }
     }
     return count;
     }
     
    public static int merge(int arr[], int si, int ei, int mid) {
        int i = si;
        int j = mid + 1;
        int k = 0;
        int temp[] = new int[ei - si + 1];
        int count = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count++;
            }
        }

        return count;
    }

    public static int mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return 0;
        }
        int mid = si + ((ei - si) / 2);
        return mergeSort(arr, si, mid) + mergeSort(arr, mid + 1, ei) + merge(arr, si, ei, mid);

    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 1, 3, 5 };
        System.out.println(mergeSort(arr, 0, arr.length - 1));
    }
}
