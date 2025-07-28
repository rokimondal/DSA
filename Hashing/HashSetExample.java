import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(100);
        hs.add(4);
        hs.add(2);
        hs.add(4);
        hs.add(50);
        hs.add(3);
        hs.add(7);
        // System.out.println(hs);
        // hs.remove(2);
        // System.out.println(hs.contains(2));
        // hs.clear();
        // System.out.println(hs.isEmpty());
        Iterator<Integer> it = hs.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        // while (it.hasNext()) {//this will not work
        //     System.out.print(it.next() + " ");
        // }

        for (int e : hs) {
            System.out.print(e + " ");
        }

    }
}
