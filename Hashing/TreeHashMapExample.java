import java.util.TreeMap;

public class TreeHashMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> hm = new TreeMap<>();

        // put
        hm.put("India", 150);
        hm.put("China", 50);
        hm.put("Bhopal", 200);
        hm.put("Indonasia", 300);

        System.out.println(hm);
    }
}
