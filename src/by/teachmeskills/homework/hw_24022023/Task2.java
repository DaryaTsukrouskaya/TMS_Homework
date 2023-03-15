package by.teachmeskills.homework.hw_24022023;

public class Task2 {
    public static void main(String[] args) {
        int amoeba = 1;
        for (int i = 3; i <= 24; i += 3) {
            amoeba *= 2;
            System.out.println("Number of amoebas after " + i + " hours " + "is: " + amoeba);
        }
    }
}
