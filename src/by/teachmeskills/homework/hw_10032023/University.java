package by.teachmeskills.homework.hw_10032023;

public class University {
    private int universityNum;
    private int studentNum;
    private Season universitySeason;

    public University(int universityNum, int studentNum, Season universitySeason) {
        this.universityNum = universityNum;
        this.studentNum = studentNum;
        this.universitySeason = universitySeason;
    }

    public void getInfo() {
        System.out.print("University № " + this.universityNum + "," + "the number of students " + this.studentNum);
        Season s = Season.SUMMER;
        if (this.universitySeason == s) {
            System.out.print(", now we are resting.");
        } else {
            System.out.print(", now we are learning.");
        }
    }

    public static void main(String[] args) {
        University university=new University(531,600,Season.AUTUMN);
        university.getInfo();
    }
}
