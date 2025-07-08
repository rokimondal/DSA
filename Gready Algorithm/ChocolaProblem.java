import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int totalCost = 0;
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        while (h < costHor.length && v < costVer.length) {
            if (costHor[h] < costVer[v]) {
                totalCost += hp * costVer[v];
                v++;
                vp++;
            } else {
                totalCost += vp * costHor[h];
                h++;
                hp++;
            }
        }
        while (h < costHor.length) {
            totalCost += vp * costHor[h];
            h++;
            hp++;
        }
        while (v < costVer.length) {
            totalCost += hp * costVer[v];
            v++;
            vp++;
        }
        System.out.println(totalCost);
    }
}