import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        // put
        lhm.put("India", 150);
        lhm.put("China", 50);
        lhm.put("Bhopal", 200);

        System.out.println(lhm);
    }
}
