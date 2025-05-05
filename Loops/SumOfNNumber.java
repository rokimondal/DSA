import java.util.Scanner;

public class SumOfNNumber {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Nth number: ");
        int n = sc.nextInt();
        int i = 0;
        int sum = 0;
        while(i<=n){
            sum+=i;
            i++;
        }
        System.out.println("Sum of N Numbers : " + sum);
    }
}