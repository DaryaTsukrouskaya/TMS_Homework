package by.teachmeskills.homework.hw_14042023.WorkWithDates;

import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegistrationUtils {
    private static final String FILE_NAME = "C:\\users.txt";
    private String fullName;
    private String dateOfBirth;
    private String phoneNumber;

    public void readUserData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your Full name: ");
        fullName = scan.nextLine();
        System.out.println("Enter your birth date(year/month/day): ");
        dateOfBirth = scan.nextLine();
        System.out.println("Enter your phone number: ");
        phoneNumber = scan.nextLine();
    }

    public boolean validateData() {
        boolean validated = true;
        if (fullName.isBlank()) {
            validated = false;
        }
        if (!Pattern.matches("^(19|20)\\d\\d([-/.])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$", dateOfBirth)) {
            validated = false;
        }

        if (!(phoneNumber.contains("+375") && (phoneNumber.contains("29") || phoneNumber.contains("25") || phoneNumber.contains("44")))) {
            validated = false;
        }
        return validated;
    }

    public void createUsersFile() {
        readUserData();
        boolean validated = validateData();
        if (validated) {
            try {
                Path users = Files.createFile(Paths.get(FILE_NAME));
                Files.write(users, (fullName + " " + dateOfBirth + " " + phoneNumber).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
