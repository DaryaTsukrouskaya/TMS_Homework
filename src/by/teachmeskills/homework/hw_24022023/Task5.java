package by.teachmeskills.homework.hw_24022023;

public class Task5 {
    public static void main(String[] args) {
        int num = (int) (10 * Math.random());
        System.out.println("The number " + num + " is a power of 2?");
        powRec(num);
    }

    public static int powRec(int n) {
        if (n <= 0) {
            System.out.print("Error. The number must be natural.");
            return 0;
        }
        if (n == 1) {
            System.out.print("YES");
            return n;
        }
        if (n % 2 == 0) {
            powRec(n / 2);
        } else {
            System.out.print("NO");
        }
        return 0;
    }
}
