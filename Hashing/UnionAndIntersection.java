import java.util.HashSet;
import java.util.Iterator;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();

        for (int e : arr1) {
            hs.add(e);
        }
        for (int e : arr2) {
            hs2.add(e);
        }

        System.out.print("Intersection: ");
        for (int e : hs2) {
            if (hs.contains(e)) {
                System.out.print(e + " ");
            }
        }

        for (int e : hs2) {
            hs.add(e);
        }
        System.out.println();
        System.out.print("Union: ");
        Iterator<Integer> it = hs.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
