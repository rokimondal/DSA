import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueInJCF {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(5);
        // pq.add(1);
        // pq.add(3);
        // pq.add(8);
        // pq.add(2);
        // while (!pq.isEmpty()) {
        // System.out.print(pq.peek() + " ");
        // pq.remove();
        // }

        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("A", 5));
        pq.add(new Student("c", 1));
        pq.add(new Student("d", 3));
        pq.add(new Student("F", 8));
        pq.add(new Student("B", 2));
        while (!pq.isEmpty()) {
            System.out.print(pq.peek().name + "->" + pq.peek().rank + ", ");
            pq.remove();
        }
    }
}