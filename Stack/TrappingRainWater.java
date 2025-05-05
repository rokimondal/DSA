import java.util.Stack;

class TrappingRainWater {
    public static int calculateTrapRain(int height[], int width) {
        int n = height.length;
        // creating auxiliary array for left boundary
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (temp.isEmpty()) {
                temp.push(height[i]);
            } else if (temp.peek() < height[i]) {
                temp.push(height[i]);
            } else {
                temp.push(temp.peek());
            }
        }
        Stack<Integer> leftMost = new Stack<>();
        while (!temp.isEmpty()) {
            leftMost.push(temp.pop());
        }

        // creating auxiliary array for right boundary
        Stack<Integer> rightMost = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (rightMost.isEmpty()) {
                rightMost.push(height[i]);
            } else if (rightMost.peek() < height[i]) {
                rightMost.push(height[i]);
            } else {
                rightMost.push(rightMost.peek());
            }
        }

        // calculate trap water
        int trapWater = 0;
        for (int i = 0; i < n; i++) {
            trapWater += (Math.min(leftMost.pop(), rightMost.pop()) - height[i]) * width;
            ;
        }
        return trapWater;
    }

    public static void main(String args[]) {
        int array[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(calculateTrapRain(array, 1));
    }
}