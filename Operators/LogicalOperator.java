import java.util.Scanner;

public class LogicalOperator {
    public static void main(String args[]){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("AND operator : "+ (a>b && a==b));
        System.out.println("OR operator : "+ (a>b || a<b));
        System.out.println("NOT operator : "+ (!(a>b)));
    }
}
