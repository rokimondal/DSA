public class ReverseAraay {

    public static void reverse(int arr[]) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int array[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        reverse(array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + ", ");
    }

}
