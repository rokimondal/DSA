import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AlenDictionary {
    static class Pair {
        char src;
        char dest;

        Pair(char src, char dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    private static Pair getEdge(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return new Pair(a.charAt(i), b.charAt(i));
            }
        }
        if (a.length() > b.length()) {
            return new Pair('#', '#');
        }
        return null;
    }

    private static void createGraph(Map<Character, ArrayList<Character>> graph,
            String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            Pair p = getEdge(words[i], words[i + 1]);
            if (p != null) {
                if (p.src == '#' && p.dest == '#') {
                    graph.clear();
                    return;
                }
                graph.get(p.src).add(p.dest);
            }
        }
    }

    public static String findOrder(String[] words) {
        String result = "";
        if (words.length == 0) {
            return result;
        }

        Map<Character, ArrayList<Character>> graph = new HashMap<>();
        createGraph(graph, words);

        if (graph.isEmpty())
            return "";

        Map<Character, Integer> indegree = new HashMap<>();
        for (char c : graph.keySet()) {
            indegree.put(c, 0);
        }

        for (char c : graph.keySet()) {
            for (char dest : graph.get(c)) {
                indegree.put(dest, indegree.get(dest) + 1);
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Integer> set : indegree.entrySet()) {
            if (set.getValue() == 0) {
                q.add(set.getKey());
            }
        }

        while (!q.isEmpty()) {
            char curr = q.remove();
            result += curr;
            for (char dest : graph.get(curr)) {
                indegree.put(dest, indegree.get(dest) - 1);
                if (indegree.get(dest) == 0) {
                    q.add(dest);
                }
            }
        }

        if (result.length() < indegree.size()) {
            return "";
        }

        return result;
    }

    public static void main(String[] args) {
        String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
        System.out.println(findOrder(dict));
    }
}
