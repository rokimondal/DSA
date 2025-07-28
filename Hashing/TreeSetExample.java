import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(100);
        ts.add(4);
        ts.add(2);
        ts.add(4);
        ts.add(50);
        ts.add(2);
        ts.add(7);
        System.out.println(ts);
    }
}
