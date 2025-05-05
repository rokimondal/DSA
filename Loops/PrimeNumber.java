import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int number = sc.nextInt();
        int i;
        for(i=1;i<number;i++){
            if(number%i == 0 && i!=1){
                break;
            }
        }
        if(number == i){
            System.out.println("Number is Prime");
        } else{
            System.out.println("Number is not Prime");
        }
    }
}
