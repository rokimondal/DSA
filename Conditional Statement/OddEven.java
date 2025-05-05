import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int a =sc.nextInt();
        if(a%2 == 0){
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }
    }
}
