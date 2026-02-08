public class MinMaxElementQuery {
    static int maxTree[];
    static int minTree[];

    public static void initMax(int n) {
        maxTree = new int[4 * n];
    }

    public static void buildMaxTree(int arr[], int i, int si, int sj) {
        if (si == sj) {
            maxTree[i] = arr[si];
            return;
        }

        int mid = (si + sj) / 2;
        buildMaxTree(arr, 2 * i + 1, si, mid);
        buildMaxTree(arr, 2 * i + 2, mid + 1, sj);

        maxTree[i] = Math.max(maxTree[2 * i + 1], maxTree[2 * i + 2]);
    }

    private static int getMaxUtill(int arr[], int i, int si, int sj, int qi, int qj) {
        if (qj < si || sj < qi) {
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) {
            return maxTree[i];
        } else {
            int mid = (si + sj) / 2;
            int left = getMaxUtill(arr, 2 * i + 1, si, mid, qi, qj);
            int right = getMaxUtill(arr, 2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(left, right);
        }
    }

    public static int getMax(int arr[], int qi, int qj) {
        return getMaxUtill(arr, 0, 0, arr.length - 1, qi, qj);
    }

    private static void updateMaxUtill(int i, int si, int sj, int idx, int newValue) {
        if (idx < si || idx > sj) {
            return;
        }
        maxTree[i] = Math.max(maxTree[i], newValue);
        if (si != sj) {
            int mid = (si + sj) / 2;
            updateMaxUtill(2 * i + 1, si, mid, idx, newValue);
            updateMaxUtill(2 * i + 2, mid + 1, sj, idx, newValue);
        }
    }

    public static void updateMax(int arr[], int idx, int newValue) {
        arr[idx] = newValue;
        updateMaxUtill(0, 0, arr.length - 1, idx, newValue);
    }

    public static void initMin(int n) {
        minTree = new int[4 * n];
    }

    public static void buildMinTree(int arr[], int i, int si, int sj) {
        if (si == sj) {
            minTree[i] = arr[si];
            return;
        }

        int mid = (si + sj) / 2;
        buildMinTree(arr, 2 * i + 1, si, mid);
        buildMinTree(arr, 2 * i + 2, mid + 1, sj);

        minTree[i] = Math.min(minTree[2 * i + 1], minTree[2 * i + 2]);
    }

    private static int getMinUtill(int arr[], int i, int si, int sj, int qi, int qj) {
        if (qj < si || sj < qi) {
            return Integer.MAX_VALUE;
        } else if (si >= qi && sj <= qj) {
            return minTree[i];
        } else {
            int mid = (si + sj) / 2;
            int left = getMinUtill(arr, 2 * i + 1, si, mid, qi, qj);
            int right = getMinUtill(arr, 2 * i + 2, mid + 1, sj, qi, qj);
            return Math.min(left, right);
        }
    }

    public static int getMin(int arr[], int qi, int qj) {
        return getMinUtill(arr, 0, 0, arr.length - 1, qi, qj);
    }

    private static void updateMinUtill(int i, int si, int sj, int idx, int newValue) {
        if (idx < si || idx > sj) {
            return;
        }
        minTree[i] = Math.min(minTree[i], newValue);
        if (si != sj) {
            int mid = (si + sj) / 2;
            updateMinUtill(2 * i + 1, si, mid, idx, newValue);
            updateMinUtill(2 * i + 2, mid + 1, sj, idx, newValue);
        }
    }

    public static void updateMin(int arr[], int idx, int newValue) {
        arr[idx] = newValue;
        updateMinUtill(0, 0, arr.length - 0, idx, newValue);
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
        int n = arr.length;
        // initMax(n);
        // buildMaxTree(arr, 0, 0, n - 1);
        // for (int e : maxTree) {
        // System.out.print(e + " ");
        // }
        // System.out.println();
        // System.out.println(getMax(arr, 5, 8));
        // updateMax(arr, 5, 20);
        // System.out.println(getMax(arr, 5, 8));
        // for (int e : maxTree) {
        // System.out.print(e + " ");
        // }
        initMin(n);
        buildMinTree(arr, 0, 0, n - 1);
        for (int e : minTree) {
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println(getMin(arr, 0, 8));
        updateMin(arr, 2, -5);
        System.out.println(getMin(arr, 0, 8));
        for (int e : minTree) {
            System.out.print(e + " ");
        }
    }
}