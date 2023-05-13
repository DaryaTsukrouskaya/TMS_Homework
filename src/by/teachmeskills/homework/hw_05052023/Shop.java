package by.teachmeskills.homework.hw_05052023;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Shop {
    private int clientNumber = 0;
    private ReentrantLock reentrantLock;

    public Shop() {
        reentrantLock = new ReentrantLock();
    }

    public void enterShop() {
        clientNumber++;
    }

    public void leaveShop() {
        try {
            reentrantLock.lock();
            if (clientNumber < 4) {
                System.out.println("The shop closed for 10 seconds");
                Thread.sleep(10000);
            }
            clientNumber--;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            reentrantLock.unlock();
        }
    }

}
