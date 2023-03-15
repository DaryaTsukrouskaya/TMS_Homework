package by.teachmeskills.homework.hw_17032023;

import java.io.*;

public class CopyPalindromsToNewFile {
    public static <exc> void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/Admin/Desktop/palindromfile.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/Users/Admin/Desktop/newpalindromfile.txt"))) {
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
