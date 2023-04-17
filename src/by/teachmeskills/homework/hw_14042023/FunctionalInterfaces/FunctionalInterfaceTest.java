package by.teachmeskills.homework.hw_14042023.FunctionalInterfaces;

import java.util.Scanner;

public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        System.out.println("Enter number(1-2):");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        switch (number) {
            case 1:
                FunctionalInterface<String> functionalInterface1 = str -> new StringBuilder(str).reverse().toString();
                String reverseStr = functionalInterface1.method("java");
                System.out.println(reverseStr);
                break;
            case 2:
                FunctionalInterface<Integer> functionalInterface2 = num -> {
                    int factorial = 1;
                    for (int i = 1; i <= num; i++) {
                        factorial *= i;
                    }
                    return factorial;
                };
                System.out.println(functionalInterface2.method(3));
                break;
            default:
                System.out.println("Please enter number 1-2");
        }
    }
}
