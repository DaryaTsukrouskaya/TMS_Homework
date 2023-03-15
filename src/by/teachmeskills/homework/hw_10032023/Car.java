package by.teachmeskills.homework.hw_10032023;

import by.teachmeskills.homework.hw_10032023.exceptions.CarStartException;

public class Car {
    protected int price;
    protected int speed;
    protected String model;

    public Car(int price, int speed, String model) {
        this.price = price;
        this.speed = speed;
        this.model = model;
    }

    public Car() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void start() throws CarStartException {
        int num = (int) (Math.random() * 20);
        if (num % 2 == 0) {
            throw new CarStartException("Car is not started because random number is even. Please, try again.");
        }
        System.out.println("The car is running");
    }
}
