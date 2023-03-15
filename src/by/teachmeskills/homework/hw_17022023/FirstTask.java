package by.teachmeskills.homework.hw_17022023;

import java.util.Scanner;

public class FirstTask {
        public static void main(String[] args) {
            System.out.println("Please enter the  rectangle sides : ");
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Please enter circle radious: ");
            int r = scanner.nextInt();
            double CircleS = 3.14 * r * r;
            if ((a * b) <= CircleS) {
                System.out.println("The answer is - Yes, the rectangle can be blocked");
            } else {
                System.out.println("The answer is - No, the rectangle can't be blocked");
            }

        }
    }

