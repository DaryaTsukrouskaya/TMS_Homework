package by.teachmeskills.homework.hw_17032023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PalindromUtil {
    private static final String FILE_NAME1 = "C:/Users/Admin/Desktop/palindromfile.txt";
    private static final String FILE_NAME2 = "C:/Users/Admin/Desktop/newpalindromfile.txt";

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME1));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME2))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                StringBuilder palindromCheck = new StringBuilder(str);
                if (str.equalsIgnoreCase(palindromCheck.reverse().toString())) {
                    bufferedWriter.write(str + "\n");
                    bufferedWriter.flush();
                }
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
