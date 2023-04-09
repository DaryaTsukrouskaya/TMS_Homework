package by.teachmeskills.homework.hw_03032023.robot.hands;

public class ToshibaHand implements IHand{
    private int price;

    public ToshibaHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Toshiba hand is raised.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
