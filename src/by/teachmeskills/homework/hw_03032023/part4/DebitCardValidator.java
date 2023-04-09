package by.teachmeskills.homework.hw_03032023.part4;

public class DebitCardValidator {
    public void validateDebitCard(String num, String type, String name, String date, String cvv) {
        class DebitCard {
            private String cardNumber;
            private String cardType;
            private String customerName;
            private String validity;
            private String cvvCode;

            public DebitCard(String cardNumber, String cardType, String customerName, String validity, String cvvCode) {
                this.cardNumber = cardNumber;
                this.cardType = cardType;
                this.customerName = customerName;
                this.validity = validity;
                this.cvvCode = cvvCode;
            }

            private void validCardNumber() {
                if (cardNumber.length() == 16) {
                    System.out.println("Correct card-number ");
                } else {
                    System.out.println("Incorrect card-number ");
                }
            }

            private void validCardType() {
                if (cardType.equals("Debit")) {
                    System.out.println("Correct card type ");
                } else {
                    System.out.println("Incorrect card-type ");
                }
            }

            private void validCardCustomerName() {
                if (!(customerName.isBlank())) {
                    System.out.println("User is specified.");
                } else {
                    System.out.println("You need to specify user ");
                }
            }

            private void validCardDate() {
                char[] validMass = validity.toCharArray();
                if (validMass[3] == '2' && validMass[4] >= '3') {
                    System.out.println("Card has normal expiration date");
                } else {
                    System.out.println("Card has expired");
                }
            }


            private void validCardCvv() {
                if (cvv.length() == 3) {
                    System.out.println("The card is valid.");
                } else {
                    System.out.println("The card is invalid.");
                }
            }

        }

        DebitCard dCard = new DebitCard(num, type, name, date, cvv);
        dCard.validCardCvv();
        dCard.validCardCustomerName();
        dCard.validCardDate();
        dCard.validCardType();
        dCard.validCardNumber();

    }
}
