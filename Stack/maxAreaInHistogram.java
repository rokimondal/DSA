import java.util.Stack;

public class maxAreaInHistogram {

    public static int maxArea(int heights[]) {
        int n = heights.length;
        int nextSmallerL[] = new int[n];
        int nextSmallerR[] = new int[n];
        Stack<Integer> s = new Stack<>();
        // calculate left smaller
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerL[i] = -1;
            } else {
                nextSmallerL[i] = s.peek();
            }
            s.push(i);
        }
        
        //empty stack
        while (!s.isEmpty()) {
            s.pop();
        }
        // calculate right smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextSmallerR[i] = n;
            } else {
                nextSmallerR[i] = s.peek();
            }
            s.push(i);
        }

        int maxArea = Integer.MIN_VALUE;

        // finding max area
        for (int i = 0; i < n; i++) {
            int width = nextSmallerR[i] - nextSmallerL[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int heights[] = { 2, 1, 5, 6, 2, 3 };
        System.out.println(maxArea(heights));
    }
}
