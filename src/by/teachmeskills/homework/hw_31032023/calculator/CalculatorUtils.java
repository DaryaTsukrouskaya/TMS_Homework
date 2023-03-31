package by.teachmeskills.homework.hw_31032023.calculator;

public class CalculatorUtils {
    private CalculatorUtils() {
    }

    public static <T extends Number, D extends Number> Double sum(T a, D b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, D extends Number> Double sub(T a, D b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static <T extends Number, D extends Number> Double mult(T a, D b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number, D extends Number> Double div(T a, D b) {
        return a.doubleValue() / b.doubleValue();
    }

}
