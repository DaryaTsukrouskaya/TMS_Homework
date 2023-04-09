package by.teachmeskills.homework.hw_03032023.animal;

public class Main {
    public static void main(String[] args) {
        Animal hippo = new Hippo("hippo.jpg", "grass", 3, new Animal.Boundaries(7, 8), new Animal.Location(60, 70));
        Canine dog = new Dog("dog.jpg", "dog food", 5, new Animal.Boundaries(6, 3), new Animal.Location(90, 80));
        Feline cat = new Cat("cat.jpg", "fish", 5, new Animal.Boundaries(4, 2), new Animal.Location(40, 70));
        Feline lion = new Lion("lion.jpg", "meat", 5, new Animal.Boundaries(18, 9), new Animal.Location(120, 60));
        Feline tiger = new Tiger("tiger.jpg", "meat", 5, new Animal.Boundaries(6, 3), new Animal.Location(90, 70));
        Canine wolf = new Wolf("wolf.jpg", "haer", 5, new Animal.Boundaries(7, 11), new Animal.Location(90, 80));
        Animal[] animals = {hippo, dog, cat, lion, tiger, wolf};
        Feline[] feline = {cat, lion, tiger};
        Canine[] canine = {dog, wolf};
        for (Animal a : animals) {
            a.eat();
            a.makeNoise();
            a.sleep();
            a.roam();
            System.out.println();
        }
        for (Feline f : feline) {
            f.eat();
            f.makeNoise();
            f.sleep();
            f.roam();
            System.out.println();
        }
        for (Canine f : canine) {
            f.eat();
            f.makeNoise();
            f.sleep();
            f.roam();
            System.out.println();
        }


    }
}
