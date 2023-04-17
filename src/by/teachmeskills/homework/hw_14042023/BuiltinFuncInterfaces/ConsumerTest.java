package by.teachmeskills.homework.hw_14042023.BuiltinFuncInterfaces;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<HeavyBox> heavyBoxConsumer1 = c -> System.out.println("Отгрузили ящик с весом " + c.getWeight());
        Consumer<HeavyBox> heavyBoxConsumer2 = c -> System.out.println("Отправляем ящик с весом " + c.getWeight());
        Consumer<HeavyBox> heavyBoxConsumer3 = heavyBoxConsumer1.andThen(heavyBoxConsumer2);
        HeavyBox heavyBox = new HeavyBox(100);
        heavyBoxConsumer3.accept(heavyBox);
    }
}
