package by.teachmeskills.homework.hw_17022023;

import java.util.Scanner;

public class SixthTask {
    public static void main(String[] args) {
        System.out.println("Please enter the array size: ");
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[][] mass = new int[size][size];
        System.out.println("Array :");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mass[i][j] = (int) (10 * Math.random());
                System.out.print(mass[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (mass[i][j] % 2 == 0) {
                    mass[i][j] = 0;
                } else {
                    mass[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mass[i][j]);
            }
            System.out.println();
        }
    }
}
