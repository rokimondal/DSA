import java.util.PriorityQueue;

public class NRopesWithMinimumCost {
    public static int minimumCost(int arr[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele: arr){
            pq.add(ele);
        }
        int ans=0;
        while(pq.size()>1){
            int sum = pq.poll() + pq.poll();
            ans+=sum;
            pq.add(sum);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 6};
        System.out.println(minimumCost(arr));
    }
}
