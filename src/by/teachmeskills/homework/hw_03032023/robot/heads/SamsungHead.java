package by.teachmeskills.homework.hw_03032023.robot.heads;

public class SamsungHead implements IHead{
    private int price;

    public SamsungHead(int price) {
        this.price = price;
    }
    @Override
    public void speak() {
        System.out.println("Samsung head is speaking.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
