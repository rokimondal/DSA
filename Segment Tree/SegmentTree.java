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

    private static int getSumUtill(int i, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj) {
            return 0;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        } else {
            int mid = (si + sj) / 2;
            return getSumUtill(2 * i + 1, si, mid, qi, qj) + getSumUtill(2 * i + 2, mid + 1, sj, qi, qj);
        }
    }

    public static int getSum(int arr[], int qi, int qj) {
        return getSumUtill(0, 0, arr.length - 1, qi, qj);
    }

    private static void updateUtill(int i, int si, int sj, int idx, int diff) {
        if (idx < si || idx > sj) {
            return;
        }
        tree[i] += diff;
        if (si != sj) {
            int mid = (si + sj) / 2;
            updateUtill(2 * i + 1, si, mid, idx, diff);
            updateUtill(2 * i + 2, mid+1, sj, idx, diff);
        }
    }

    public static void update(int arr[], int idx, int newVal) {
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        updateUtill(0, 0, arr.length - 1, idx, diff);
    }

    public static void main(String[] args) {
        int n = 8;
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        init(n);
        build(arr, 0, 0, n - 1);
        // for (int e : tree) {
        // System.out.print(e + " ");
        // }
        // System.out.println();

        System.out.println(getSum(arr, 0, 2));
        update(arr, 1, 0);
        System.out.println(getSum(arr, 0, 2));
    }
}
