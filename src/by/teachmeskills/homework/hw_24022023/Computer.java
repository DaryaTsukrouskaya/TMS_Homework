package by.teachmeskills.homework.hw_24022023;

public class Computer {
    String processorType;
    int ramVolume;
    int hardDiskCapacity;
    boolean computerisAlive;
    boolean computerOffState;

    {
        computerisAlive = true;
        computerOffState = true;
    }

    public Computer(String processorType, int ramVolume, int hardDiskCapacity) {
        this.processorType = processorType;
        this.ramVolume = ramVolume;
        this.hardDiskCapacity = hardDiskCapacity;
    }

    public void getInfo() {
        System.out.println("The processor type: " + processorType);
        System.out.println("Amount of RAM: " + ramVolume);
        System.out.println("The hard disk capacity: " + hardDiskCapacity);
    }

    public void turnOn(int i) {
        if (computerOffState) {
            if (computerisAlive) {
                int randomNum = (int) (Math.random() * 2);
                if (i == randomNum) {
                    System.out.println("Сongratulations! You've guessed the number,so now your computer is turned on.");
                    computerOffState = false;
                }
                if (i != randomNum) {
                    System.out.println("Oops... computer is burned down.");
                    computerisAlive = false;
                }
            } else {
                System.out.println("Sorry,but you can't turn on the compute, it's finished.");
            }

        } else {
            System.out.println("Your computer is already turned on.");
        }
    }

    public void turnOff(int i) {
        if (!computerOffState) {
            if (computerisAlive) {
                int randomNum = (int) (Math.random() * 2);
                if (i == randomNum) {
                    System.out.println("Сongratulations! You've guessed the number,so now your computer is turned off.");
                    computerOffState = true;
                }
                if (i != randomNum) {
                    System.out.println("Oops... computer is burned down.");
                    computerisAlive = false;
                }
            } else {
                System.out.println("Sorry,but you can't turn off the compute, it's finished.");
            }
        }
        else {
            System.out.println("Your computer is already turned off.");
        }
    }
}
