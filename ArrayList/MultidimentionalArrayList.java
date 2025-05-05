import java.util.ArrayList;

public class MultidimentionalArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> main = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        main.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(8);
        list2.add(8);
        list1.add(8);

        main.add(list2);
        System.out.println(main);
    }
}
