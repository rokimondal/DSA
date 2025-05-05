import java.util.Scanner;

public class largestOfThree {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Number: ");
        int a =sc.nextInt();
        System.out.print("Enter Second Number: ");
        int b =sc.nextInt();
        System.out.print("Enter Third Number: ");
        int c =sc.nextInt();

        if(a>b){
            if(a>c){
                System.out.println("Max Number is "+a);
            }else{
                System.out.println("Max Number is "+c);
            }
        } else{
            if(b>c){
                System.out.println("Max Number is "+b);
            }else{
                System.out.println("Max Number is "+c);
            }
        }
    }
}