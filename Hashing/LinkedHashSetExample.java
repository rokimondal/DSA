import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(100);
        lhs.add(4);
        lhs.add(2);
        lhs.add(4);
        lhs.add(50);
        lhs.add(2);
        lhs.add(7);
        System.out.println(lhs);
    }
}
