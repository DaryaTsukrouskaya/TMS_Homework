package by.teachmeskills.homework.hw_14042023.BuiltinFuncInterfaces;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> {
            int x = (int) (10 * Math.random());
            return x;
        };
    }
}
