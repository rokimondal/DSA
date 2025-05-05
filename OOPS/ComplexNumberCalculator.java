public class ComplexNumberCalculator {
    public static void main(String[] args) {
        Complex.product(2, 4, 3, 5);
    }
}

class Complex {
    public static void sum(int real1, int imaginary1, int real2, int imaginary2) {
        System.out.println((real1 + real2) + " + " + (imaginary1 + imaginary2) + "i");
    };

    public static void sub(int real1, int imaginary1, int real2, int imaginary2) {
        System.out.println((real1 - real2) + " + " + (imaginary1 - imaginary2) + "i");
    };

    public static void product(int real1, int imaginary1, int real2, int imaginary2) {
        System.out.println(((real1 * real2) - (imaginary1 * imaginary2)) + " + " + ((real1 * imaginary2)
                + (imaginary1 * real2)) + "i");
    }
}
