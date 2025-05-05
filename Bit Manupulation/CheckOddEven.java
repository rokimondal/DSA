import java.util.Scanner;;

public class CheckOddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bitMask = 1;
        System.out.print("Enter Number: ");
        int number = sc.nextInt();
        if ((number & bitMask) == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }
}
