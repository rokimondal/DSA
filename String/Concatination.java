import java.util.Scanner;

public class Concatination {
    public static void display(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.err.print(str.charAt(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = sc.next();
        System.out.print("Enter last name: ");
        String lastName = sc.next();
        String fullName = firstName + " " + lastName;
        display(fullName);
    }
}