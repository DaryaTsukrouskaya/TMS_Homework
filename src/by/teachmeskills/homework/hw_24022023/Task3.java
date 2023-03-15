package by.teachmeskills.homework.hw_24022023;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] mass = new int[10];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = (int) (10 * Math.random());
        }
        System.out.println("Ten-element array : " + Arrays.toString(mass));
        System.out.println("Sum of array elements : " + recurtionSum(mass, mass.length - 1));
    }

    public static int recurtionSum(int[] m, int i) {
        int sum = 0;
        if (i == 0) {
            return m[i];
        }
        sum = m[i] + recurtionSum(m, i - 1);
        return sum;
    }

}
