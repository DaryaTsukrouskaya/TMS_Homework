package by.teachmeskills.homework.hw_03032023.transport;

public class WarPlane extends AirTransport {
    private boolean surrenderSystem;
    private int rocketNum;

    public WarPlane(int horsePower, int maxSpeed, int weight, String model, int wingSpan, int minLengthOfRunwayStrip,
                    boolean surrenderSystem, int rocketNum) {
        super(horsePower, maxSpeed, weight, model, wingSpan, minLengthOfRunwayStrip);
        this.surrenderSystem = surrenderSystem;
        this.rocketNum = rocketNum;
    }

    @Override
    public String toString() {
        return "WarPlane{" +
                "surrenderSystem=" + surrenderSystem +
                ", rocketNum=" + rocketNum +
                ", wingSpan=" + wingSpan +
                ", minLengthOfRunwayStrip=" + minLengthOfRunwayStrip +
                ", horsePower=" + horsePower +
                ", maxSpeed=" + maxSpeed +
                ", kilowatts power=" + kilowattePower() +
                ", weight=" + weight +
                ", model='" + model + '\'' +
                '}';
    }

    public void shot() {
        if (this.rocketNum != 0) {
            System.out.println("The rocket is launched");
        } else {
            System.out.println("Ammo missing");
        }

    }

    public void ejection() {
        if (this.surrenderSystem) {
            System.out.println("Ejection was successful.");
        } else {
            System.out.println("Ejection failed, you dont have such a system.");
        }
    }
}
