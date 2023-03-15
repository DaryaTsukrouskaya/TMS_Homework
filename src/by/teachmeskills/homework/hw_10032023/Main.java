package by.teachmeskills.homework.hw_10032023;

import by.teachmeskills.homework.hw_10032023.exceptions.CarStartException;

public class Main {
    public static void main(String[] args) {
        Car hamer = new Car(5000000, 400, "hamer");
        Car reno = new Car(3000, 300, "reno");
        Car mazda = new Car(20000, 400, "mazda");
        try {
            hamer.start();
            reno.start();
            mazda.start();
        } catch (CarStartException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
