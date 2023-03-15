package by.teachmeskills.homework.hw_17022023;

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        for (; ; ) {
            System.out.print("Please enter number(1-7) to get result: ");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            switch (num) {
                case (1):
                    System.out.println("Monday");
                    break;
                case (2):
                    System.out.println("Tuesday");
                    break;
                case (3):
                    System.out.println("Wednesday");
                    break;
                case (4):
                    System.out.println("Thursday");
                    break;
                case (5):
                    System.out.println("Friday");
                    break;
                case (6):
                    System.out.println("Saturday");
                    break;
                case (7):
                    System.out.println("Sunday");
                    break;
                default:
                    System.out.println("Incorrect input, please try again");

            }
            if (num > 0 && num < 7) return;
        }

    }
}
