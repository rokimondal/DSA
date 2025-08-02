public class PrefixProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            this.freq = 1;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static String uniquePrefix(String key) {
        Node curr = root;
        int i = 0;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] != null) {
                if (curr.children[idx].freq == 1) {
                    i = level + 1;
                    break;
                }
            }
            curr = curr.children[idx];
        }
        return key.substring(0, i);
    }

    public static void main(String[] args) {
        String words[] = { "zebra", "dog", "du", "dove" };
        for (String str : words) {
            insert(str);
        }
        String prefix[] = new String[words.length];
        for (int i = 0; i < prefix.length; i++) {
            prefix[i] = uniquePrefix(words[i]);
        }
        for (String str : prefix) {
            System.out.print(str +" ");
        }
    }
}
