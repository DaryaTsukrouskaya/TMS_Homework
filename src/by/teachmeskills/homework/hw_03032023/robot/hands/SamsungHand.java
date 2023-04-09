package by.teachmeskills.homework.hw_03032023.robot.hands;

public class SamsungHand implements IHand{
    private int price;

    public SamsungHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("SamsungHand is raised.");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
