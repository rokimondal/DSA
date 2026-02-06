public class SegmentTree {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static int build(int arr[], int sti, int start, int end) {
        if (start == end) {
            return tree[sti] = arr[start];
        }
        int mid = start + ((end - start) / 2);
        build(arr, 2 * sti + 1, start, mid);
        build(arr, 2 * sti + 2, mid + 1, end);
        tree[sti] = tree[2 * sti + 1] + tree[2 * sti + 2];
        return tree[sti];
    }

    public static void main(String[] args) {
        int n = 8;
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        init(n);
        build(arr, 0, 0, n - 1);
        for (int e : tree) {
            System.out.print(e + " ");
        }
    }
}
