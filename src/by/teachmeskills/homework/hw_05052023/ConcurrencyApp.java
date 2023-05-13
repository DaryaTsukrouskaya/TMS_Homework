package by.teachmeskills.homework.hw_05052023;

import java.util.concurrent.Semaphore;

public class ConcurrencyApp {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        Shop shop = new Shop();
        for (int i = 1; i < 8; i++) {
            new Client(semaphore, shop, i).start();
        }
    }
}
