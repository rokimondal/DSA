import java.util.Scanner;

public class ArithmeticOperator {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        //Binary
        System.out.println("Addition: "+(a+b));
        System.out.println("Subtraction: "+(a-b));
        System.out.println("Multiplication: "+(a*b));
        System.out.println("Division: "+(a/b));
        System.out.println("Remainder: "+(a%b));
        
        //Unary
        System.out.println("Increment: "+(++a));
        System.out.println("Decrement: "+(--b));
    }
}
