import java.util.Scanner;

public class PrimeNumbers {
    public static boolean prime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Range: ");
        int range = sc.nextInt();
        for (int i=0; i<range; i++) {
            if(prime(i))
                System.out.print(i+", ");
        }
    }
}
