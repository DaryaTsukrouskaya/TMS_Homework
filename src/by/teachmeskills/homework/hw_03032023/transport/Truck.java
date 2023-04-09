package by.teachmeskills.homework.hw_03032023.transport;

public class Truck extends Terrestrial {
    private int bearingCapacity;

    public Truck(int horsePower, int maxSpeed, int weight, String model, int wheelsNum, int fuelConsumption, int bearingCapacity) {
        super(horsePower, maxSpeed, weight, model, wheelsNum, fuelConsumption);
        this.bearingCapacity = bearingCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "bearingCapacity=" + bearingCapacity +
                ", wheelsNum=" + wheelsNum +
                ", fuelConsumption=" + fuelConsumption +
                ", horsePower=" + horsePower + ", " +
                "kilowatts power=" + kilowattePower() +
                ", maxSpeed=" + maxSpeed +
                ", weight=" + weight +
                ", model='" + model + '\'' +
                '}';
    }

    public void loadingCapacity(int weight) {
        if (weight <= this.bearingCapacity) {
            System.out.println("The truck is loaded.");
        } else {
            System.out.println("Sorry, but you need a bigger truck.");
        }
    }
}
