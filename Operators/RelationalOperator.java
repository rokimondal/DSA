import java.util.Scanner;

public class RelationalOperator {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("equal operator: "+(a==b));
        System.out.println("not equal operator: "+(a!=b));
        System.out.println("greater than operator: "+(a>b));
        System.out.println("less than operator: "+(a<b));
        System.out.println("greater equal operator: "+(a>=b));
        System.out.println("less equal operator: "+(a<=b));
    }
}
