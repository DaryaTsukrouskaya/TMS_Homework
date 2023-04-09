package by.teachmeskills.homework.hw_03032023.part4;

public class ValidTest {
    public static void main(String[] args) {
        DebitCardValidator cardVal = new DebitCardValidator();
        cardVal.validateDebitCard("1234567899876543", "Debit", "Darya", "05.25", "364");
        Calculator calc = new Calculator(7, 8);
        calc.multiplication();
    }

}
