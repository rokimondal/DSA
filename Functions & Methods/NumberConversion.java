public class NumberConversion {
    public static int BinaryToDecimal(int binary){
        int decimal = 0;
        for(int i=1; binary>0; i*=2, binary/=10){
            decimal += i*(binary%10);
        }
        return decimal;
    }
    public static int DecimalToBinary(int decimal){
        int binary=0;
        for(int i = 1;decimal>0; decimal/=2, i*=10){
            binary += (decimal%2)*i; 
        }
        return binary;
    }
    public static void main(String[] args) {
        System.out.println(DecimalToBinary(10));
    }
}
