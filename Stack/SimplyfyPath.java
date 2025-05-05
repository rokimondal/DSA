import java.util.Stack;

public class SimplyfyPath {
    public static String pathSimplyfy(String path) {
        Stack<String> s = new Stack<>();
        String temp = "";
        for (int i = 1; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == '/') {
                if (temp.length() > 0) {
                    if (temp.equals("..")) {
                        if (!s.isEmpty())
                            s.pop();
                    } else if (!temp.equals(".")) {
                        s.push(temp);
                    }
                    temp = "";
                }
            } else {
                temp += ch;
            }
        }
        if (temp.length() > 0) {
            if (temp.equals("..")) {
                if (!s.isEmpty())
                    s.pop();
            } else if (!temp.equals(".")) {
                s.push(temp);
            }
            temp = "";
        }

        StringBuilder newStr = new StringBuilder();
        if(s.isEmpty()) newStr.append("/");
        for (String p : s) {
            newStr.append("/").append(p);
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        String path1 = "/apna/college/.././code/";
        String path2 = "/a/b/../c";
        String path3 = "/a/../..";
        System.out.println(pathSimplyfy(path1)); // → /apna/code
        System.out.println(pathSimplyfy(path2)); // → /a/c
        System.out.println(pathSimplyfy(path3)); // → /
    }
}
