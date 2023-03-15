package by.teachmeskills.homework.hw_10032023;

import java.util.Arrays;

public class StringUtils {
    private StringUtils() {
    }

    public static void lastStringElement(String str) {
        System.out.println("Last index of " + str + " : " + str.charAt(str.length() - 1));
    }

    public static void endWith(String str) {
        if (str.endsWith("!!!")) {
            System.out.println("Yes, your string " + str + " ends with a substring \"!!!\"");
        } else {
            System.out.println("No, your string " + str + "doesn't end with a substring \"!!!\"");
        }
    }

    public static void startWith(String str) {
        String phrase = "Сиреневенький синхрофазарон";
        if (str.startsWith(phrase)) {
            System.out.println("Yeas, your string starts with phrase \"Сиреневенький синхрофазарон\"");
        } else {
            System.out.println("No, your string starts with phrase \"Сиреневенький синхрофазарон\"");
        }
    }

    public static void containsSubstring(String processedString, String substring) {
        if (processedString.contains(substring)) {
            System.out.println("Yeas, your string " + processedString + " contains " + substring);
        } else {
            System.out.println("No, your string " + processedString + " doesn't contains " + substring);
        }
    }

    public static String stringToUpperCase(String str) {
        return str.toUpperCase();
    }

    public static String stringToLowerCase(String str) {
        return str.toLowerCase();
    }

    public static void stringbuilderStringReturn(String str, String str2) {
        StringBuilder result = new StringBuilder(str);
        result.append(str2);
        System.out.println(result);
    }

    public static void replaceSymbolToWord(String str) {
        StringBuilder string = new StringBuilder(str);
        string.insert(string.indexOf("="), "равно");
        System.out.println(string.deleteCharAt(string.indexOf("=")));
    }


    public static void palindromWordFounder(String str) {
        String[] strMass = str.split(" ");
        for (int i = 0; i <= strMass.length - 1; i++) {
            if (strMass[i].equals(",")) continue;
            StringBuilder rev = new StringBuilder(strMass[i]);
            if (strMass[i].equalsIgnoreCase(rev.reverse().toString())) {
                System.out.println("Palindrom word: " + strMass[i]);
            }
        }
    }

    public static void stringMiddle(String str1, String str2) {
        String str = str1 + str2;
        if (str.length() % 2 == 0) {
            int middle = str.length() / 2;
            System.out.println("Your string middle: " + str.charAt(middle-1) + str.charAt(middle));
        } else System.out.println("Two lines must have an even number of letters,please retry");

    }

    public static void stringSplit(String str) {
        String[] strings = str.split(" ");
        for (int i = 0; i <= strings.length - 1; i++) {
            System.out.println(strings[i]);
        }
    }
}
