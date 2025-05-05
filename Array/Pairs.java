public class Pairs {

    public static void pairs(int arr[]) {
        int tp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("( " + arr[i] + ", " + arr[j] + " )");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total No. of Pairs: " + tp);
    }

    public static void main(String[] args) {
        int array[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        pairs(array);
    }

}
