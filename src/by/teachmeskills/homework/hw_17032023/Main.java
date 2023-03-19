package by.teachmeskills.homework.hw_17032023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final String FILE_PATH1 = "C:\\Users\\Admin\\Desktop\\check.txt";
    private static final String FILE_PATH2 = "C:\\Users\\Admin\\Desktop\\new.txt";

    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH1));
             FileWriter fileWriter = new FileWriter(FILE_PATH2)) {
            String sentences[];
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = fileReader.readLine()) != null) {
                sb.append(s + System.lineSeparator());
            }
            sentences = sb.toString().split("[.!?]\\s*");
            for (int i = 0; i < sentences.length; i++) {
                if (TextFormater.sentencePalindromCheck(sentences[i]) == true || (TextFormater.sentenceWordnumber(sentences[i]) >= 3
                        && TextFormater.sentenceWordnumber(sentences[i]) <= 5)) {
                    fileWriter.write(sentences[i]);
                    fileWriter.write(".");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
