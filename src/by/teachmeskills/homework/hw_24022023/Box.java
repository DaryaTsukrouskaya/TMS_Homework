package by.teachmeskills.homework.hw_24022023;

import java.util.Arrays;

public class Box {
    static int founder;

    public static void main(String[] args) {
        int key = 123;
        int rows = (int) (Math.random() * 10);
        while (rows == 0) {
            rows = (int) (Math.random() * 10);
        }
        int columns = (int) (Math.random() * 10);
        while (columns == 0) {
            columns = (int) (Math.random() * 10);
        }
        int[][] mass = new int[rows][columns];
        int i = (int) (Math.random() * 10);
        int j = (int) (Math.random() * 10);
        while (i >= rows) {
            i = (int) (Math.random() * 10);
        }
        while (j >= columns) {
            j = (int) (Math.random() * 10);
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                mass[r][c] = 0;
            }
        }

        mass[i][j] = key;

        System.out.println("Result of searching for a key in a cyclic function : " + cycleFunction(mass));
        System.out.println("Result of searching for a key in a recursion function : " + recursionFunction(mass, 0, 0));
    }

    public static int cycleFunction(int[][] m) {
        for (int r = 0; r < m.length; r++) {
            for (int k = 0; k < m[r].length; k++) {
                if (m[r][k] != 0) {
                    founder = m[r][k];
                    break;
                }
            }
        }
        return founder;
    }

    public static int recursionFunction(int[][] a, int r, int c) {
        int i = r;
        int j = c;
        int result = 0;
        if (a[i][j] != 0) return a[i][j];
        if (j >= a[i].length - 1 && i < a.length - 1) {
            j = 0;
            i++;
        }
          else if (j < a[i].length - 1 && i <= a.length - 1) {
            j++;
        }
        result += recursionFunction(a, i, j);
        return result;
    }
}
