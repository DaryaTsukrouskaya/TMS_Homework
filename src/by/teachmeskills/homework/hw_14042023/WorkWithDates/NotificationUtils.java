package by.teachmeskills.homework.hw_14042023.WorkWithDates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class NotificationUtils {

    public static void sendNotifications(String filePath) {
        String user;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((user = bufferedReader.readLine()) != null) {
                String[] userData = user.split(" ");
                String date = userData[2];
                String[] dateParts = date.split("[-/.]");
                LocalDate currentDate = LocalDate.now();
                LocalDate birthday = LocalDate.of(currentDate.getYear(), Integer.parseInt(dateParts[1]),
                        Integer.parseInt(dateParts[2]));
                LocalDate sevenDaysBeforeBirthday = LocalDate.of(currentDate.getYear(), birthday.getMonth(),
                        birthday.getDayOfMonth()).minusDays(7);
                LocalDate sevenDaysAfterBirthday = LocalDate.of(currentDate.getYear(), birthday.getMonth(), birthday.getDayOfMonth()).plusDays(7);


                if (currentDate.isEqual(sevenDaysBeforeBirthday)) {
                    System.out.println("Уважаемый(-моя), " + userData[0] + " " + userData[1] + " , магазин Oz " +
                            "в ваш день рождения дарит вам в скидку 15% на все товары. \n" +
                            "Скидка действует с " + sevenDaysBeforeBirthday.getDayOfMonth() + " " + sevenDaysBeforeBirthday.getMonth() + " " +
                            sevenDaysBeforeBirthday.getYear() + " по " + sevenDaysAfterBirthday.getDayOfMonth() + " " + sevenDaysAfterBirthday.getMonth() +
                            " " + sevenDaysAfterBirthday.getYear() + ". Будем рады видеть вас в нашем магазине.");
                }
                if (currentDate.isEqual(birthday)) {
                    System.out.println("Уважаемый(-моя), " + userData[0] + " " + userData[1] + " , магазин Oz " +
                            "поздравляет вас с днем рождения и дарит вам в скидку 15% на все товары. \n" +
                            "Скидка действует с " + sevenDaysBeforeBirthday.getDayOfMonth() + " " + sevenDaysBeforeBirthday.getMonth() + " " +
                            sevenDaysBeforeBirthday.getYear() + " по " + sevenDaysAfterBirthday.getDayOfMonth() + " " + sevenDaysAfterBirthday.getMonth() +
                            " " +
                            sevenDaysAfterBirthday.getYear() + ". Будем рады видеть вас в нашем магазине.");
                }
                if (currentDate.isEqual(sevenDaysAfterBirthday.minusDays(1))) {
                    System.out.println("Уважаемый(-моя), " + userData[0] + " " + userData[1] + " , магазин Oz " +
                            "напоминает вам про скидку 15% на все товары. \n" +
                            "Скидка действует с " + sevenDaysBeforeBirthday.getDayOfMonth() + " " + sevenDaysBeforeBirthday.getMonth() + " " +
                            sevenDaysBeforeBirthday.getYear() + " по " + sevenDaysAfterBirthday.getDayOfMonth() + sevenDaysAfterBirthday.getMonth() + " " +
                            sevenDaysAfterBirthday.getYear() + ". Будем рады видеть вас в нашем магазине.");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
