package by.teachmeskills.homework.hw_03032023.part4;

public class Calculator {
    private int num1;
    private int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void subtraction() {
        int sub = num1 - num2;
        System.out.println("The subtraction of numbers is: " + sub);
    }

    public void addition() {
        int add = num1 + num2;
        System.out.println("The sum is : " + add);
    }

    public void multiplication() {
        int multi = num1 * num2;
        System.out.println("The product of numbers is: " + multi);
    }
}
