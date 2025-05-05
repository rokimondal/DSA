import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = { 1, 3, 2, 5 };
        int end[] = { 2, 4, 3, 6 };

        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        for(int i=0; i<start.length; i++){
            System.out.println(activities[i][0]+" "+activities[i][1]+" "+activities[i][2]);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(activities[0][0]);
        int lastend = activities[0][2];
        int maxAct = 1;

        for (int i = 1; i < start.length; i++) {
            if (activities[i][1] >= lastend) {
                maxAct++;
                ans.add(activities[i][0]);
                lastend = activities[i][2];
            }
        }

        System.out.println("Total activity: " + maxAct);
        for (int i : ans) {
            System.out.print("A" + i + " ");
        }
        System.out.println();
    }
}