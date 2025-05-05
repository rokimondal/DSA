public class TowerOfHonoi {
    public static void towerOfHonoi(char src, char aux, char des, int n) {
        if (n == 1) {
            System.out.println("Move Disk 1 from " + src + " to " + des);
            return;
        }
        towerOfHonoi(src, des, aux, n - 1);
        System.out.println("Move Disk " + n + " from " + src + " to " + des);
        towerOfHonoi(aux, src, des, n - 1);
    }

    public static void main(String[] args) {
        towerOfHonoi('a', 'b', 'c', 3);
    }
}
