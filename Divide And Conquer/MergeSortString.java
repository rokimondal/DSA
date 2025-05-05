public class MergeSortString {
    public static void merge(String arr[], int si, int ei, int mid) {
        int i = si;
        int j = mid + 1;
        int k = 0;
        String temp[] = new String[ei - si + 1];
        while (i <= mid && j <= ei) {
            if (greater(arr[j], arr[i])) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static boolean greater(String a, String b) {
        int n = a.length();
        int m = b.length();
        int i = 0;
        while (a.charAt(i) == b.charAt(i) && i < n && i < m) {
            i++;
        }
        if (!(i < n)) {
            return false;
        }
        if (!(i < m)) {
            return true;
        }
        if (a.charAt(i) > b.charAt(i)) {
            return true;
        }
        return false;
    }

    public static void mergeSort(String arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + ((ei - si) / 2);
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, ei, mid);
    }

    public static void main(String[] args) {
        String arr[] = { "sun", "earth", "mars", "mercury" };
        mergeSort(arr, 0, arr.length - 1);
        for (String element : arr) {
            System.out.print(element + " ");
        }
    }
}