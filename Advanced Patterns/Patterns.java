public class Patterns {
    public static void hollowRectangle(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row; j++) {
                if (i == 1 || i == row || j == 1 || j == row) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void invertedRotatedHalfPyramid(int row) {
        for (int i = 1; i <= row; i++) {
            // spaces
            for (int j = 1; j <= row - i; j++) {
                System.out.print("  ");
            }

            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void invertedHalfPyramidWithNumber(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void floydTriangle(int row) {
        int counter = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter++ + " ");
            }
            System.out.println();
        }
    }

    public static void zeroOneTriangle(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly(int row) {
        for (int i = 1; i <= (row / 2); i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= (2 * ((row / 2) - i)); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = row / 2; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= (2 * ((row / 2) - i)); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void solidRhombus(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= row; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void hollowRhombus(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= row; j++) {
                if (i == 1 || i == row || j == 1 || j == row) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = row - 1; i >= 1; i--) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void NumberPyramid(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(i + "   ");
            }

            System.out.println();
        }
    }

    public static void Palindromic(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print("  ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }

            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        hollowRectangle(8);
        System.out.println();
        invertedRotatedHalfPyramid(8);
        System.out.println();
        invertedHalfPyramidWithNumber(8);
        System.out.println();
        floydTriangle(8);
        System.out.println();
        zeroOneTriangle(8);
        System.out.println();
        butterfly(8);
        System.out.println();
        solidRhombus(8);
        System.out.println();
        hollowRhombus(8);
        System.out.println();
        diamond(8);
        System.out.println();
        NumberPyramid(8);
        System.out.println();
        Palindromic(8);
    }
}