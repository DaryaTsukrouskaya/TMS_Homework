package by.teachmeskills.homework.hw_03032023.animal;

import static by.teachmeskills.homework.hw_03032023.animal.Dop.animal;

public class Dog extends Canine {
    public Dog(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("The dog is making noise: gav-gav");
    }

    @Override
    protected void eat() {
        System.out.println("The dog is eating dog food");
    }
}
