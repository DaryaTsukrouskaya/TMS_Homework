package by.teachmeskills.homework.hw_17032023;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class СensorshipСheck {
    private static final String FILE_PATH1 = "C:\\Users\\Admin\\Desktop\\FileForCensorshipCheck.txt";
    private static final String FILE_PATH2 = "C:\\Users\\Admin\\Desktop\\ObsceneWords.txt";

    public static void main(String[] args) {
        try (BufferedReader fileReader1 = new BufferedReader(new FileReader(FILE_PATH1));
             BufferedReader fileReader2 = new BufferedReader(new FileReader(FILE_PATH2))) {
            String t;
            String o;
            int obsceneWordsNumber = 0;
            StringBuilder sbForText = new StringBuilder();
            StringBuilder sbForObsceneWords = new StringBuilder();
            String[] textSentences;
            String[] obsceneWords;
            while ((t = fileReader1.readLine()) != null) {
                sbForText.append(t + System.lineSeparator());
            }
            while ((o = fileReader2.readLine()) != null) {
                sbForObsceneWords.append(o + System.lineSeparator());
            }
            textSentences = sbForText.toString().split("[.!?]\\s*");
            obsceneWords = sbForObsceneWords.toString().split("\r\n");
            for (int i = 0; i < textSentences.length; i++) {
                for (int j = 0; j < obsceneWords.length; j++) {
                    if (textSentences[i].contains(obsceneWords[j])) {
                        obsceneWordsNumber++;
                    }
                }
            }
            if (obsceneWordsNumber > 0) {
                System.out.println("Text has not been censored!\r\n" + "The number of obscene sentences: " + obsceneWordsNumber);
            } else {
                System.out.println("Text successfully passed Censorship Check!");
            }

            for (int i = 0; i < textSentences.length; i++) {
                for (int j = 0; j < obsceneWords.length; j++) {
                    if (textSentences[i].contains(obsceneWords[j])) {
                        System.out.println(textSentences[i] + ".");

                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
