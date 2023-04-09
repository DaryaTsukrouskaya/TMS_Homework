package by.teachmeskills.homework.hw_03032023.robot;

import by.teachmeskills.homework.hw_03032023.robot.hands.IHand;
import by.teachmeskills.homework.hw_03032023.robot.heads.IHead;
import by.teachmeskills.homework.hw_03032023.robot.legs.ILeg;


public class Robot implements IRobot {
    private IHand hand;
    private IHead head;
    private ILeg leg;
    private String name;

    public Robot(IHand hand, IHead head, ILeg leg, String name) {
        this.name = name;
        this.hand = hand;
        this.head = head;
        this.leg = leg;
    }

    public IHand getHand() {
        return hand;
    }

    public IHead getHead() {
        return head;
    }

    public ILeg getLeg() {
        return leg;
    }

    public void setHand(IHand hand) {
        this.hand = hand;
    }

    public void setHead(IHead head) {
        this.head = head;
    }

    public void setLeg(ILeg leg) {
        this.leg = leg;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public void action() {
        hand.upHand();
        head.speak();
        leg.step();
    }

    @Override
    public int getPrice() {
        int price = head.getPrice() + hand.getPrice() + leg.getPrice();
        return price;
    }
}
