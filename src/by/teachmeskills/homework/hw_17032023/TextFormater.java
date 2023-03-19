package by.teachmeskills.homework.hw_17032023;

public class TextFormater {
    public TextFormater() {
    }

    public static int sentenceWordnumber(String str) {
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    public static boolean sentencePalindromCheck(String str) {
        boolean palindrom = false;
        String[] substr;
        substr = str.split("[ ,]+");
        for (int i = 0; i < substr.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(substr[i]);
            if (substr[i].length() > 1 && substr[i].equalsIgnoreCase(stringBuilder.reverse().toString())) {
                palindrom = true;
                break;
            }
        }
        return palindrom;
    }
}

