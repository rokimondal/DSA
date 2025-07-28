import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        // put
        hm.put("India", 150);
        hm.put("China", 50);
        System.out.println(hm.put("Bhopal", 200));

        System.out.println(hm);

        // get
        System.out.println(hm.get("India"));
        System.out.println(hm.get("Japan"));

        // containsKey
        System.out.println(hm.containsKey("China"));
        System.out.println(hm.containsKey("Indonesia"));

        // remove
        System.out.println(hm.remove("India"));
        System.out.println(hm.remove("India"));

        // Iterate
        Set<String> keys = hm.keySet();
        for (String k : keys) {
            System.out.println("key: " + k + " Value: " + hm.get(k));
        }

        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            System.out.println("key: " + e.getKey() + " Value: " + e.getValue());
        }
    }
}
