package by.teachmeskills.homework.hw_03032023.transport;

public abstract class Transport {
    protected int horsePower;
    protected int maxSpeed;
    protected int weight;
    protected String model;

    public Transport(int horsePower, int maxSpeed, int weight, String model) {
        this.horsePower = horsePower;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.model = model;
    }

    public double kilowattePower() {
        double i = 0.74;
        double kilPow = this.horsePower / i;
        return kilPow;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "horsePower=" + horsePower +
                ", maxSpeed=" + maxSpeed +
                ", weight=" + weight +
                ", model='" + model + '\'' +
                '}';
    }
}
