package by.teachmeskills.homework.hw_17032023;

public class TextFormater {
    public static int sentenceWordnumber(String str) {
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

//    public static boolean sentencePalindromCheck(String str) {
//
//    }
}
