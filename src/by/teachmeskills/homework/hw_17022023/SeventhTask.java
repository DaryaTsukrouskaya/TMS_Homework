package by.teachmeskills.homework.hw_17022023;

public class SeventhTask {
    public static void main(String[] args) {
        int rows = 10;
        int columns = 0;
        int[][] mass = new int[rows][];
        for (int i = 0; i < rows; i++) {
            mass[i] = new int[(int) (10*Math.random())];
            for (int j = 0; j < mass[i].length; j++) {
                mass[i][j] = (int) (10 * Math.random());
            }
        }
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                System.out.print(mass[i][j] + " ");
            }
            System.out.println();
        }
    }
}
