import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Hello World " + a);
    }
}
