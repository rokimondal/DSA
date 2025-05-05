public class CreationOfStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        for (char ch = 'A'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
