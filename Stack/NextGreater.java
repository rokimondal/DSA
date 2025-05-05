import java.util.Stack;

public class NextGreater {
    public static int[] nextGreater(int arr[]) {
        int n = arr.length;
        int nextGtr[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                nextGtr[i] = -1;
            } else {
                nextGtr[i] = arr[s.peek()];
            }
            s.push(i);
        }
        return nextGtr;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3, 5, 9 };
        int nxtGtr[] = nextGreater(arr);
        for (int ele : nxtGtr) {
            System.out.print(ele + " ");
        }
    }
}
