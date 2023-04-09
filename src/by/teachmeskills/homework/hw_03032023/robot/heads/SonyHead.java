package by.teachmeskills.homework.hw_03032023.robot.heads;

public class SonyHead implements IHead{
    private int price;

    public SonyHead(int price) {
        this.price = price;
    }

    @Override
    public void speak() {
        System.out.println("Sony head is speaking.");
    }
    @Override
    public int getPrice() {
        return price;
    }
}
