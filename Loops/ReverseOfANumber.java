import java.util.Scanner;

public class ReverseOfANumber {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int number = sc.nextInt();
        int reverseNumber = 0;
        for(;number!=0;number/=10){
            reverseNumber = reverseNumber*10 + (number%10);
        }
        System.out.println("Reverse Number is "+reverseNumber);
    }   
}
