package by.teachmeskills.homework.hw_03032023.robot.heads;

public class ToshibaHead implements IHead{
    private int price;

    public ToshibaHead(int price) {
        this.price = price;
    }

    @Override
    public void speak() {
        System.out.println("Toshiba head is speaking.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
