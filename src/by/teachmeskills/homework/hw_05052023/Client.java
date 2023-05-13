package by.teachmeskills.homework.hw_05052023;

import java.util.concurrent.Semaphore;

import static java.lang.Math.random;

public class Client extends Thread {
    private Semaphore semaphore;
    private Shop shop;
    private int id;
    private int clientShoppingDuration;

    public Client(Semaphore semaphore, Shop shop, int id) {
        this.semaphore = semaphore;
        this.id = id;
        clientShoppingDuration = (int) random() * 9000;
        if (clientShoppingDuration == 0) {
            clientShoppingDuration = 1000;
        }
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("The client" + id + " visited the shop");
            shop.enterShop();
            sleep(clientShoppingDuration);
            shop.leaveShop();
            System.out.println("The client" + id + " leaved the shop");
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
