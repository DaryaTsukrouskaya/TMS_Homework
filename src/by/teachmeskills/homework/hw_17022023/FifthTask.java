package by.teachmeskills.homework.hw_17022023;

public class FifthTask {
    public static void main(String[] args) {
        int size = 10;
        boolean sorted = false;
        int temp = 0;
        int[] mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = (int) (10 * Math.random());
            System.out.print(mass[i] + " ");
        }
        System.out.println();
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < size - 1; i++) {
                if (mass[i] > mass[i + 1]) {
                    temp = mass[i];
                    mass[i] = mass[i + 1];
                    mass[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print(mass[i] + " ");
        }
    }
}
