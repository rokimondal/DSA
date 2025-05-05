public class basic {
    public static int Factorial(int number){
        int result = 1;
        while(number>1){
            result *= number;
            number--;
        }
        return result;
    }
    public static float Binomial(int n, int r){
        return (Factorial(n)/(Factorial(r)*Factorial(n-r)));
    }
    public static void main(String[] args) {
        System.out.println( "Result: "+Binomial(10,2));
    }
}