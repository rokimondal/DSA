class TrappingRainWater {
    public static int calculateTrapRain(int height[], int width) {
        int n = height.length;
        // creating auxiliary array for left boundary
        int leftBoundary[] = new int[n];
        leftBoundary[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftBoundary[i] = Math.max(leftBoundary[i - 1], height[i]);
        }

        // creating auxiliary array for right boundary
        int rightBoundary[] = new int[height.length];
        rightBoundary[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightBoundary[i] = Math.max(rightBoundary[i + 1], height[i]);
        }

        // calculate trap water
        int trapWater = 0;
        for (int i = 0; i < n; i++) {
            trapWater += (Math.min(leftBoundary[i], rightBoundary[i]) - height[i]) * width;
        }
        return trapWater;
    }

    public static void main(String args[]) {
        int array[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(calculateTrapRain(array, 1));
    }
}