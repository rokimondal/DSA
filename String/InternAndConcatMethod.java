public class InternAndConcatMethod {

    public static void internMethod() {
        // Java program to illustrate intern() method

        // S1 refers to object in the Heap Area
        String s1 = new String("GFG");

        // S2 refers to object in the SCP Area
        String s2 = s1.intern();

        // Comparing memory locations
        System.out.println(s1 == s2);

        // Comparing values
        System.out.println(s1.equals(s2));

        // S3 refers to object in the SCP Area
        String s3 = "GFG";

        // Comparing s2 and s3 in SCP
        System.out.println(s2 == s3);
    }

    public static void concatMethod() {
        // Java program to illustrate intern() method

        // S1 refers to object in the Heap Area
        String s1 = new String("GFG");

        // S2 refers to object in the Heap (after concat)
        String s2 = s1.concat("GFG");

        // S3 refers to object in SCP Area after intern()
        String s3 = s2.intern();

        System.out.println(s2 == s3);

        // S4 refers to object in SCP Area
        String s4 = "GFGGFG";

        System.out.println(s3 == s4);
    }

    public static void main(String[] args) {
        internMethod();
        concatMethod();
    }
}
