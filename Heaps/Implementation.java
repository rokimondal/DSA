import java.util.*;

public class Implementation {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int child = arr.size() - 1;
            int parr = (child - 1) / 2;

            while (child < parr) {
                int temp = arr.get(child);
                arr.set(child, arr.get(parr));
                arr.set(parr, temp);

                child = parr;
                parr = (child - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }
    }

    public static void main(String[] args) {

    }
}