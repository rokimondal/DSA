import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums){
            hs.add(num);
        }
        System.out.println(hs.size());
    }
}
