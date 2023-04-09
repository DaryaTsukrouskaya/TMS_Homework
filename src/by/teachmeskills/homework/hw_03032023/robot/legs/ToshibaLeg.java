package by.teachmeskills.homework.hw_03032023.robot.legs;

public class ToshibaLeg implements ILeg {
    private int price;

    public ToshibaLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Toshiba leg stepped.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
