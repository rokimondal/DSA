public class LengthOfAString {
    public static int findLength(String str) {
        if(str.equals("")){
            return 0;
        }
        return 1 + findLength(str.substring(1));
    }

    public static void main(String[] args) {
        String str="Roki";
        System.out.println(findLength(str));
    }
}
