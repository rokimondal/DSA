public class LargestElement {
    public static int largest(int arr[]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
            if (smallest > arr[i]) {
                smallest = arr[i];
            }
        }
        System.out.println("Smallest: " + smallest);
        return largest;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 879, 234, 96, 24, 984, 5 };
        System.out.println("Largest: " + largest(arr));
    }
}
