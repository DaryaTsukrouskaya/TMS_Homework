package by.teachmeskills.homework.hw_03032023.animal;

import static by.teachmeskills.homework.hw_03032023.animal.Dop.animal;

public abstract class Canine extends Animal {
    public Canine(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }

    protected void roam() {
        System.out.println("The animal is roaming in a flock");
    }

}
