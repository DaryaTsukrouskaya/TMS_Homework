package by.teachmeskills.homework.hw_03032023.transport;

public abstract class AirTransport extends Transport {
     protected int wingSpan;
     protected int minLengthOfRunwayStrip;

    public AirTransport(int horsePower, int maxSpeed, int weight, String model, int wingSpan, int minLengthOfRunwayStrip) {
        super(horsePower, maxSpeed, weight, model);
        this.wingSpan = wingSpan;
        this.minLengthOfRunwayStrip = minLengthOfRunwayStrip;
    }
}
