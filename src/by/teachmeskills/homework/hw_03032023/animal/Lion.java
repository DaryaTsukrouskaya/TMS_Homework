package by.teachmeskills.homework.hw_03032023.animal;

import static by.teachmeskills.homework.hw_03032023.animal.Dop.animal;

public class Lion extends Feline {
    public Lion(String picture, String food, int hunger, Boundaries boundaries, Location location) {
        super(picture, food, hunger, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("The lion is making noise: RRRRRRR");
    }

    @Override
    protected void eat() {
        System.out.println("The lion is eating meat");
    }
}

