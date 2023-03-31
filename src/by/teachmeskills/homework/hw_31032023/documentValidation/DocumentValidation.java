package by.teachmeskills.homework.hw_31032023.documentValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class DocumentValidation {
    private static final String FILE_NAME = "C:\\documentReport.txt";

    public static void main(String[] args) {
        ArrayList<String> filesList = new ArrayList<>();
        HashSet<String> documents = new HashSet<>();
        HashMap<String, String> documentReport = new HashMap<String, String>();
        String file = "";
        String str = "";
        String validStr = "";
        System.out.println("Please, enter paths and filenames: ");
        for (; ; ) {
            Scanner scan = new Scanner(System.in);
            file = scan.nextLine();
            if (file.equals("0")) {
                break;
            }
            filesList.add(file);
        }

        for (int i = 0; i < filesList.size(); i++) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filesList.get(i)))) {
                while ((str = bufferedReader.readLine()) != null) {
                    documents.add(str);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


        for (String doc : documents) {
            if (doc.length() == 15) {
                if (doc.startsWith("docnum") || doc.startsWith("contract") && doc.matches("^[a-zA-Zа-яёА-ЯЁ0-9]*$")) {
                    validStr = "valid";
                } else {
                    validStr = "invalid document name";
                }
            } else {
                validStr = "invalid document length";
            }
            documentReport.put(doc, validStr);

        }

        try {
            Path reportFile = Files.createFile(Paths.get(FILE_NAME));
            for (Map.Entry entry : documentReport.entrySet()) {
                Files.write(reportFile, (entry.getKey() + " : " + entry.getValue() + '\n').getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
