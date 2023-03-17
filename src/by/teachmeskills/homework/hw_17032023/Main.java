package by.teachmeskills.homework.hw_17032023;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static final String FILE_PATH = "C:\\Users\\Admin\\Desktop\\check.txt";

    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader(FILE_PATH);
             FileWriter fileWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\new.txt")) {
            char buffer[] = new char[1000];
            String sentences[];
            int s;
            while ((s = fileReader.read(buffer)) != -1) {
                if (s < 1000) {
                    buffer = Arrays.copyOf(buffer, s);
                }
            }
            String string = new String(buffer);
            sentences = string.split("[.!?]\\s*");
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
