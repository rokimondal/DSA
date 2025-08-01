import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFreq {
    static class Info implements Comparable<Info> {
        char ele;
        int freq;

        Info(char ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }

        @Override
        public int compareTo(Info i) {
            if (this.freq == i.freq) {
                return this.ele - i.ele;
            }
            return i.freq - this.freq;
        }
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Info> q = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            q.add(new Info(e.getKey(), e.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Info data = q.remove();
            for (int j = 0; j < data.freq; j++) {
                sb.append(data.ele);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("cccaaa"));
    }
}
