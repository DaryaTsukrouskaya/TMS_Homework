package by.teachmeskills.homework.hw_03032023.transport;

public abstract class Terrestrial extends Transport {
    protected int wheelsNum;
    protected int fuelConsumption;

    public Terrestrial(int horsePower, int maxSpeed, int weight, String model, int wheelsNum, int fuelConsumption) {
        super(horsePower, maxSpeed, weight, model);
        this.wheelsNum = wheelsNum;
        this.fuelConsumption = fuelConsumption;

    }
}
