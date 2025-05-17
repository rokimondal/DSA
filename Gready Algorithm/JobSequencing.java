import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    public static class Job {
        int id;
        int profit;
        int deadline;

        Job(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }

    public static void main(String[] args) {
        int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][1], jobInfo[i][0]));
        }

        Collections.sort(jobs, (Job a, Job b)->b.profit-a.profit);

        int time=0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline>time){
                ans.add(curr.id);
                time++;
            }
        }

        System.out.println(ans);
    }
}
