package by.teachmeskills.homework.hw_24022023;

public class Task1 {
    public static void main(String[] args) {
        double race = 1000;
        double total = race;
        for (int i = 0; i < 6; i++) {
            race += race * 10 / 100;
            total += race;
        }
        System.out.println("The total distance that the athlete will run in 7 days: " + total);
    }
}
