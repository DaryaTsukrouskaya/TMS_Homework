package by.teachmeskills.homework.hw_14042023.BuiltinFuncInterfaces;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate1 = c -> c != null;
        Predicate<String> predicate2 = c -> !c.isBlank();
        Predicate<String> predicate3 = predicate1.and(predicate2);
    }
}
