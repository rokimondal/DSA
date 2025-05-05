import java.util.Scanner;

public class PassFail {
    public static void main(String args[]){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks: ");
        int marks = sc.nextInt();
        System.out.println(marks>=33?"Pass":"Fail");
    }
}
