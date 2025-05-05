import java.util.ArrayList;

public class PairSum2 {
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int n = list.size();
        // two pointer approach
        int bp = 0;
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1))
                bp = i;
        }
        int lp = bp + 1, rp = bp;
        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);
            if (sum == target)
                return true;
            if (sum < target)
                lp = (lp + 1) % n;
            if (sum > target)
                rp = (n + rp - 1) % n;
        }
        return false;
    }

    public static boolean pairSum1(ArrayList<Integer> list, int target) { // sorted array
        int n = list.size();
        // brute force
        // for(int i=0;i<n-1;i++){
        // for(int j=i+1;j<n;j++){
        // if(target == list.get(i)+list.get(j)) return true;
        // }
        // }

        // two pointer approach
        int lp = 0, rp = n - 1;
        while (lp < rp) {
            int sum = list.get(lp) + list.get(rp);
            if (sum == target)
                return true;
            if (sum < target)
                lp++;
            if (sum > target)
                rp--;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int target = 10;
        System.out.println(pairSum2(list, target));
    }
}
