package by.teachmeskills.homework.hw_03032023.transport;

public class PassengerCar extends Terrestrial {
    private String carBodyType;
    private int passengerNum;

    public PassengerCar(int horsePower, int maxSpeed, int weight, String model, int wheelsNum, int fuelConsumption,
                        String carBodyType, int passengerNum) {
        super(horsePower, maxSpeed, weight, model, wheelsNum, fuelConsumption);
        this.carBodyType = carBodyType;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "carBodyType='" + carBodyType + '\'' +
                ", passengerNum=" + passengerNum +
                ", wheelsNum=" + wheelsNum +
                ", fuelConsumption=" + fuelConsumption +
                ", horsePower=" + horsePower +
                ", maxSpeed=" + maxSpeed +
                ", weight=" + weight +
                ", kilowatts power=" + kilowattePower() +
                ", model='" + model + '\'' +
                '}';
    }

    private double spentFuel(double distance) {
        double sFuel = this.fuelConsumption * distance / 100;
        return sFuel;
    }

    public void distanceToDrive(double t) {
        double distance = t * this.maxSpeed;
        System.out.println("During " + t + " hours " + this.model + " moving at a maximum speed of " + this.maxSpeed + " km/h " +
                "will pass " + distance + " km and spend " + spentFuel(distance) + " liters of fuel.");

    }
}
