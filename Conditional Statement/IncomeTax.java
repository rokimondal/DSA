import java.util.Scanner;

public class IncomeTax {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your income: ");
        int income = sc.nextInt();
        int totalTax = 0;
        if(income<500000){
            totalTax = 0;
        } else if(income<1000000){
            totalTax = (income*20)/100;
        }else{
            totalTax = (income*30)/100;
        }
        System.out.println("Total tax : "+totalTax);
    }
}
