package by.teachmeskills.homework.hw_03032023.animal;

import static by.teachmeskills.homework.hw_03032023.animal.Dop.animal;

class Wolf extends Canine {
    public Wolf(String picture, String food, int hunger, Animal.Boundaries boundaries, Animal.Location location) {
        super(picture, food, hunger, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("The wolf is making noise: Uoooooo");
    }

    @Override
    protected void eat() {
        System.out.println("The wolf is eating hare");
    }
}

