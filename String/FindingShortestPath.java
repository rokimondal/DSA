public class FindingShortestPath {
    public static float shortestPath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'N')
                y++;
            if (str.charAt(i) == 'S')
                y--;
            if (str.charAt(i) == 'E')
                x++;
            if (str.charAt(i) == 'W')
                x--;
        }
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(shortestPath("path"));
    }
}
