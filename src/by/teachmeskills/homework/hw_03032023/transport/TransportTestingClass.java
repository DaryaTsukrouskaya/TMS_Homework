package by.teachmeskills.homework.hw_03032023.transport;

public class TransportTestingClass {
    public static void main(String[] args) {
        Transport car = new PassengerCar(500, 300, 600, "BMW", 4, 500,
                "Universal", 5);
        WarPlane wplane = new WarPlane(700, 2000, 8000, "Plane", 300, 5000,
                true, 0);
        Transport truck = new Truck(500, 300, 900, "Camaz", 4, 500,
                5);
        Transport plane = new CivilAircraft(500, 300, 900, "Boeng-300", 4, 500,
                5, true);
        Transport[] transport = {car, wplane, truck, plane};
        for (int i = 0; i < transport.length; i++) {
            System.out.println(transport[i].toString());
        }
        wplane.shot();
    }
}
