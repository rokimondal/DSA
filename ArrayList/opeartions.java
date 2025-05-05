import java.util.ArrayList;
import java.util.Collections;

public class opeartions {
    public static void printReverse(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--)
            System.out.print(list.get(i) + " ");
    }

    public static int maximum(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int num : list) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static void swap(ArrayList<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(7);
        // printReverse(list);
        // System.out.println(maximum(list));
        // System.out.println(list);
        // swap(list, 1, 5);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}
