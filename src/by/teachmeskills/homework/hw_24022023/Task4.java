package by.teachmeskills.homework.hw_24022023;

public class Task4 {
    public static void main(String[] args) {
        int A = (int) (10 * Math.random());
        int B = (int) (10 * Math.random());
        System.out.println("Numbers: " + A + " " + B);
        System.out.print("Result: ");
        recursionFunc(A, B);
    }

    public static int recursionFunc(int a, int b) {
        System.out.print(a + " ");
        if (a == b) return a;
        if (a < b) {
            recursionFunc(a + 1, b);
        } else {
            recursionFunc(a - 1, b);
        }
        return 0;
    }
}
