public class SubArray {
    public static void bruteForce(int arr[]) {
        int count = 0;
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                System.out.print("[ ");
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    System.out.print(arr[k] + ", ");
                }
                System.out.print("]");
                maxSum = Math.max(maxSum, sum);
                minSum = Math.min(minSum, sum);
                count++;
            }
            System.out.println();
        }
        System.out.println("Total No. of Sub Array: " + count);
        System.out.println("Max sum of Sub Array: " + maxSum);
        System.out.println("Min sum of Sub Array: " + minSum);
    }

    public static int Prefix(int arr[]) {
        int maxSum = 0;
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                int sum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int kadane(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        /*
         * //to solve when all the elements are negative
         * boolean negative=true;
         * int maxValue=Integer.MIN_VALUE;
         * for(int i=0;i<arr.length;i++){
         * if(arr[i]>0){
         * negative = false;
         * }
         * maxValue = Math.max(maxValue, arr[i]);
         * }
         * if(negative){
         * return maxValue
         * }
         * for (int i = 0; i < arr.length; i++) {
         * currSum += arr[i];
         * if (currSum < 0)
         * currSum = 0;
         * maxSum = Math.max(maxSum, currSum);
         * }
         */

        // to solve when all the elements are negative
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }

    public static void main(String args[]) {
        int array[] = { -2, -4, -113, -1, -11, -10 };
        System.out.println(kadane(array));
    }
}
