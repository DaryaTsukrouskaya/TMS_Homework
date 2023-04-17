package by.teachmeskills.homework.hw_14042023.BuiltinFuncInterfaces;

import java.util.function.Function;

public class FunctionTest {
    private static String str = "";
    public static void main(String[] args) {

        Function<Integer, String> function = c -> {
            if (c == 0) {
                str = "Ноль";

            } else if (c < 0) {
                str = "Меньше нуля";
            } else {
                str = "Больше нуля";
            }
            return str;
        };
    }


}
