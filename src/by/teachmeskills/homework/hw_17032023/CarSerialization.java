package by.teachmeskills.homework.hw_17032023;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CarSerialization {
    private static final String FILE_NAME = "C:/Users/Admin/Desktop/objectserfile.txt";

    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Car car = new Car("hammer", 400, 500);
            objectOutputStream.writeObject(car);
            Car newCar = (Car) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
