import java.util.*;

public class JobSequencing {
    public static class Job {
        char id;
        int deadline;
        int profit;

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void printJobScheduling(ArrayList<Job> arr) {
        int n = arr.size();
        Collections.sort(arr, (a, b) -> a.deadline - b.deadline);
        ArrayList<Job> result = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.profit - a.profit;
        });
        for (int i = n - 1; i >= 0; i--) {
            int slotAvailable;
            if (i == 0) {
                slotAvailable = arr.get(i).deadline;
            } else {
                slotAvailable = arr.get(i).deadline - arr.get(i - 1).deadline;
            }
            maxHeap.add(arr.get(i));
            while (slotAvailable > 0 && maxHeap.size() > 0) {
                Job job = maxHeap.remove();
                result.add(job);
                slotAvailable--;
            }
        }
        Collections.sort(result,(a,b)->a.deadline-b.deadline);
        for (Job job : result) {
            System.out.println("id: " + job.id + "  deadline: " + job.deadline);
        }

    }

    public static void main(String[] args) {
        ArrayList<Job> arr = new ArrayList<Job>();
        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
        System.out.println("Following is maximum " + "profit sequence of jobs");
        printJobScheduling(arr);
    }
}
