import java.util.*;

public class HashMapImplementation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;

        private LinkedList<Node> buckets[]; // N

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuckets[] = buckets;
            N = N * 2;
            buckets = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                while (!ll.isEmpty()) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) { // O(lamda) -> o(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            //
            double lamda = (double) n / N;
            if (lamda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {// O(lamda) -> o(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                return true;
            }
            return false;
        }

        public V remove(K key) {// O(lamda) -> o(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }

            return null;
        }

        public V get(K key) {// O(lamda) -> o(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }

            return null;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    keys.add(ll.get(j).key);
                }
            }

            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 150);
        hm.put("China", 50);
        hm.put("US", 150);
        hm.put("Nepal", 70);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();

        System.out.println(hm.get("India"));
        hm.remove("India");
        System.out.println(hm.get("India"));
    }
}
