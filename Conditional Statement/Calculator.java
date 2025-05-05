import java.util.Scanner;

public class Calculator {
    public static void main(String args[]){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Number: ");
        int a = sc.nextInt();
        System.out.print("Enter Second Number: ");
        int b = sc.nextInt();
        System.out.print("Enter Operation Symbol: ");
        char operation = sc.next().charAt(0);

        switch (operation) {
            case '+':
                System.out.println("Addition: "+(a+b));
                break;
            case '-':
                System.out.println("Subtraction: "+(a-b));
                break;
            case '*':
                System.out.println("Multiplication: "+(a*b));
                break;
            case '/':
                System.out.println("Division: "+(a/b));
                break;
            case '%':
                System.out.println("Modulus: "+(a%b));
                break;
            default:
                System.out.println("Invalid Operation");
                break;
        }
    }
}
