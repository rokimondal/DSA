import java.util.Scanner;

public class areaOfCircle {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle(in cm): ");
        float r = sc.nextFloat();
        double area = 3.14*r*r;
        System.out.printf("Area is %,.2f cm²\n",area);
    }
}
