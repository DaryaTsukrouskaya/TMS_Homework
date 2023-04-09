package by.teachmeskills.homework.hw_03032023.animal;

import static by.teachmeskills.homework.hw_03032023.animal.Dop.animal;

public class Hippo extends Animal {
    public Hippo(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("Hippo is making some noise");
    }

    @Override
    protected void eat() {
        System.out.println("Hippo is eating grass");
    }
}
