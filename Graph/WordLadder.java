import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    static class Pair {
        String s;
        int step;

        Pair(String s, int step) {
            this.s = s;
            this.step = step;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))
            return 1;
        Set<String> set = new HashSet<>();

        for (String s : wordList) {
            set.add(s);
        }

        if (!set.contains(endWord))
            return 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(beginWord, 1));

        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        while (!q.isEmpty()) {
            Pair p = q.remove();
            if (p.s.equals(endWord))
                return p.step;
            for (int i = 0; i < p.s.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replaceArray = p.s.toCharArray();
                    replaceArray[i] = ch;
                    String newStr = new String(replaceArray);
                    if (set.contains(newStr)) {
                        set.remove(newStr);
                        q.add(new Pair(newStr, p.step + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("poon");
        wordList.add("plee");
        wordList.add("same");
        wordList.add("poie");
        wordList.add("plie");
        wordList.add("poin");
        wordList.add("plea");

        System.out.println(ladderLength("toon", "plea", wordList));
    }
}
