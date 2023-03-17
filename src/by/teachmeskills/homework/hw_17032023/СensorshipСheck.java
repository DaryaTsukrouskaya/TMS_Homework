package by.teachmeskills.homework.hw_17032023;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class СensorshipСheck {
    private static final String FILE_PATH1 = "C:\\Users\\Admin\\Desktop\\FileForCensorshipCheck.txt";
    private static final String FILE_PATH2 = "C:\\Users\\Admin\\Desktop\\ObsceneWords.txt";

    public static void main(String[] args) {
        try (FileReader fileReader1 = new FileReader(FILE_PATH1);
             FileReader fileReader2 = new FileReader(FILE_PATH2)) {
            int t;
            int o;
            char[] textBuffer = new char[10000];
            char[] obsceneWordsBuffer = new char[100];
            String[] textSentences;
            String[] obsceneWords;
            int obsceneWordsNumber = 0;
            while ((t = fileReader1.read(textBuffer)) != -1) {
                if (t < 10000) {
                    textBuffer = Arrays.copyOf(textBuffer, t);
                }
            }
            while ((o = fileReader2.read(obsceneWordsBuffer)) != -1) {
                if (o < 100) {
                    obsceneWordsBuffer = Arrays.copyOf(obsceneWordsBuffer, o);
                }
            }
            String textString = new String(textBuffer);
            String obsceneWordsString = new String(obsceneWordsBuffer);
            textSentences = textString.split("[.!?]\\s*");
            obsceneWords = obsceneWordsString.split("\r\n");
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
