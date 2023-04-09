package by.teachmeskills.homework.hw_03032023.transport;

public class CivilAircraft extends AirTransport {
    private int passengerNum;
    private boolean businessClass;
    public CivilAircraft(int horsePower, int maxSpeed, int weight, String model, int wingSpan, int minLengthOfRunwayStrip,
                         int passengerNum, boolean businessClass) {
        super(horsePower, maxSpeed, weight, model, wingSpan, minLengthOfRunwayStrip);
        this.passengerNum = passengerNum;
        this.businessClass = businessClass;
    }

    public void passengersLoadingCapacity(int num) {
        if (num <= this.passengerNum) {
            System.out.println("The plane is loaded.");
        } else {
            System.out.println("Sorry, but you need a bigger plane.");
        }
    }

}
