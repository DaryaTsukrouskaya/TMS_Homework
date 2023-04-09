package by.teachmeskills.homework.hw_03032023.robot;

import by.teachmeskills.homework.hw_03032023.robot.hands.IHand;
import by.teachmeskills.homework.hw_03032023.robot.hands.SamsungHand;
import by.teachmeskills.homework.hw_03032023.robot.hands.SonyHand;
import by.teachmeskills.homework.hw_03032023.robot.hands.ToshibaHand;
import by.teachmeskills.homework.hw_03032023.robot.heads.IHead;
import by.teachmeskills.homework.hw_03032023.robot.heads.SamsungHead;
import by.teachmeskills.homework.hw_03032023.robot.heads.SonyHead;
import by.teachmeskills.homework.hw_03032023.robot.heads.ToshibaHead;
import by.teachmeskills.homework.hw_03032023.robot.legs.ILeg;
import by.teachmeskills.homework.hw_03032023.robot.legs.SamsungLeg;
import by.teachmeskills.homework.hw_03032023.robot.legs.SonyLeg;
import by.teachmeskills.homework.hw_03032023.robot.legs.ToshibaLeg;

public class Run {
    public static void main(String[] args) {
        int maxPriceRobotIndex = 0;
        IHand hand1 = new ToshibaHand(400);
        IHead head1 = new SonyHead(1200);
        ILeg leg1 = new SamsungLeg(3000);
        Robot robot1 = new Robot(hand1, head1, leg1, "robot1");
        IHand hand2 = new SamsungHand(5000);
        IHead head2 = new ToshibaHead(600);
        ILeg leg2 = new SonyLeg(3200);
        Robot robot2 = new Robot(hand2, head2, leg2, "robot2");
        IHand hand3 = new SonyHand(3000);
        IHead head3 = new SamsungHead(900);
        ILeg leg3 = new ToshibaLeg(25000);
        Robot robot3 = new Robot(hand3, head3, leg3, "robot3");
        robot1.action();
        System.out.println();
        robot2.action();
        System.out.println();
        robot3.action();
        Robot[] massRobot = {robot1, robot2, robot3};
        System.out.println();

        for (int i = 0; i < massRobot.length - 1; i++) {
            if (massRobot[i].getPrice() < massRobot[i + 1].getPrice()) {
                maxPriceRobotIndex = i + 1;
            }
        }
        System.out.print("The most expensive robot is " + massRobot[maxPriceRobotIndex].getName());

    }
}

