package by.teachmeskills.homework.hw_24022023;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Computer computer = new Computer("Intel Pentium 111", 256, 64);
        computer.getInfo();
        System.out.println();
        System.out.print("Please enter number(0-1):");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        computer.turnOn(num);
        computer.turnOff(num);
    }
}
