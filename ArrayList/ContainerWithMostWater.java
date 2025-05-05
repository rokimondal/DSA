import java.util.ArrayList;

public class ContainerWithMostWater {
    public static int mostTrapWater(ArrayList<Integer> height) {
        int maxWater = Integer.MIN_VALUE;
        int n = height.size();
        // brute force
        // for (int i = 0; i < n - 1; i++) {
        // for (int j = i + 1; j < n; j++) {
        // int ht = Math.min(height.get(i), height.get(j));
        // int width = j - i;
        // maxWater = Math.max(maxWater, ht * width);
        // }
        // }

        // two pointer approach
        int lp = 0, rp = n - 1;
        while (lp < rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int water = ht * width;
            maxWater = Math.max(maxWater, water);
            // if (height.get(lp) < height.get(rp)) {
            //     int hight = height.get(lp);
            //     do {
            //         lp++;
            //     } while (hight > height.get(lp) && lp < n - 1);
            // } else {
            //     int hight = height.get(rp);
            //     do {
            //         rp--;
            //     } while (hight > height.get(rp) && rp > 0);
            // }
            while (lp < rp && height.get(lp) <= ht) {
                lp++;
            }
            while (lp < rp && height.get(rp) <= ht) {
                rp--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(mostTrapWater(height));
    }
}