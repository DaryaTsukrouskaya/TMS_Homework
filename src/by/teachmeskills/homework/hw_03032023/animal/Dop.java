package by.teachmeskills.homework.hw_03032023.animal;

import java.util.Scanner;

public class Dop {
    protected static Animal[] animal = new Animal[20];
    protected static int animalNumberInMass = 0;

    public static void changeFeature(String p) {
        for (int i = 0; i < animal.length; i++) {
            if (animal[i].picture.equals(p)) {
                System.out.println("What feature do you want to change:");
                System.out.println("1 - picture, 2- food, 3 - hunger, 4- boundaries, 5- location");
                Scanner in = new Scanner(System.in);
                int num = in.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Enter picture");
                        String picChange = in.next();
                        animal[i].picture = picChange;
                        break;
                    case 2:
                        System.out.println("Enter food");
                        String foodChange = in.next();
                        animal[i].food = foodChange;
                        break;
                    case 3:
                        System.out.println("Enter hunger level");
                        int hungerChange = in.nextInt();
                        animal[i].hunger = hungerChange;
                        break;
                    case 4:
                        System.out.println("Enter boundaries");
                        int boundChange = in.nextInt();
                        animal[i].boundaries = new Animal.Boundaries(boundChange, boundChange);
                        break;
                    case 5:
                        System.out.println("Enter location");
                        int locationChange = in.nextInt();
                        animal[i].location = new Animal.Location(locationChange, locationChange);
                        break;
                    default:
                        System.out.println("Wrong number");
                }
                return;
            }
        }
    }

    public static void deleteAnimal(String p) {
        for (int i = 0; i < animal.length; i++) {
            if (animal[i].picture.equals(p)) {
                animal[i] = null;
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("Enter 1, if you want to add animal");
            System.out.println("Enter 2, if you want to get information about certain animal");
            System.out.println("Enter 3, if you want to change information about certain animal");
            System.out.println("Enter 4, if you want to delete information about certain animal");
            System.out.println("Enter 5, if you want to exit");
            System.out.print("Select a menu item(1-5): ");
            if (animalNumberInMass >= animal.length) {
                animalNumberInMass = 0;
            }
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter animal picture");
                    String p = scan.next();
                    System.out.println("Enter animal food");
                    String f = scan.next();
                    System.out.println("Enter animal hunger");
                    int h = scan.nextInt();
                    System.out.println("Enter animal first boundary");
                    int x = scan.nextInt();
                    System.out.println("Enter animal second boundary");
                    int y = scan.nextInt();
                    System.out.println("Enter animal first location");
                    int z = scan.nextInt();
                    System.out.println("Enter animal second location");
                    int q = scan.nextInt();
                    System.out.println("Choose what type of animal you want to create");
                    System.out.print("1 - dog, 2- cat, 3 - lion, 4- tiger, 5- hippo, 6- wolf: ");
                    int type = scan.nextInt();
                    switch (type) {
                        case 1:
                            Animal uDog = new Dog(p, f, h, new Animal.Boundaries(x, y), new Animal.Location(z, q));
                            animal[animalNumberInMass] = uDog;
                            animalNumberInMass++;
                            break;
                        case 2:
                            Animal uCat = new Cat(p, f, h, new Animal.Boundaries(x, y), new Animal.Location(z, q));
                            animal[animalNumberInMass] = uCat;
                            animalNumberInMass++;
                            break;
                        case 3:
                            Animal uLion = new Lion(p, f, h, new Animal.Boundaries(x, y), new Animal.Location(z, q));
                            animal[animalNumberInMass] = uLion;
                            animalNumberInMass++;
                            break;
                        case 4:
                            Animal uTiger = new Tiger(p, f, h, new Animal.Boundaries(x, y), new Animal.Location(z, q));
                            animal[animalNumberInMass] = uTiger;
                            animalNumberInMass++;
                            break;
                        case 5:
                            Animal uHippo = new Hippo(p, f, h, new Animal.Boundaries(x, y), new Animal.Location(z, q));
                            animal[animalNumberInMass] = uHippo;
                            animalNumberInMass++;
                            break;
                        case 6:
                            Animal uWolf = new Hippo(p, f, h, new Animal.Boundaries(x, y), new Animal.Location(z, q));
                            animal[animalNumberInMass] = uWolf;
                            animalNumberInMass++;
                            break;
                        default:
                            System.out.println("Unexpected value: " + type);
                    }
                    break;
                case 2:
                    System.out.println("Enter a picture of the animal, whose information you would like to see:");
                    String infoPic = scan.next();
                    Animal.getInfo(infoPic);
                    break;
                case 3:
                    System.out.println("Enter a picture of the animal, whose information you would like to change:");
                    String chPic = scan.next();
                    changeFeature(chPic);
                    break;
                case 4:
                    System.out.println("Enter a picture of the animal, whose information you would like to delete:");
                    String delPic = scan.next();
                    deleteAnimal(delPic);
                    break;
            }
            if (n == 5) return;
        }
    }
}