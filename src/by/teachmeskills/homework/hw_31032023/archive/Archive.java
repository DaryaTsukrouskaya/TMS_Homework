package by.teachmeskills.homework.hw_31032023.archive;

import java.io.File;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archive {
    private static final String PATH_NAME = "C:\\Users\\Admin\\Directory";
    private static final String FILE_NAME1 = "C:\\Users\\Admin\\Directory\\file1.txt";
    private static final String FILE_NAME2 = "C:\\Users\\Admin\\Directory\\file2.txt";
    private static final String FILE_NAME3 = "C:\\Users\\Admin\\Directory\\file3.txt";

    public static void main(String[] args) {

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("C:\\Users\\Admin\\homeworkArchive.zip"));) {
            Path directory = Files.createDirectory(Paths.get(PATH_NAME));
            File newDirectory = new File(PATH_NAME + "new");
            Path file1 = Files.createFile(Paths.get(FILE_NAME1));
            Path file2 = Files.createFile(Paths.get(FILE_NAME2));
            Path file3 = Files.createFile(Paths.get(FILE_NAME3));
            Files.write(file1, "file1 file1".getBytes());
            Files.write(file2, "file2 file2".getBytes());
            Files.write(file3, "file3 file3".getBytes());
            for (File file : directory.toFile().listFiles()) {
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zos.putNextEntry(zipEntry);
                List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
                for (String s : lines) {
                    zos.write(s.getBytes());
                }
                zos.closeEntry();
            }
            directory.toFile().renameTo(newDirectory);
            for (File f : newDirectory.listFiles()) {
                System.out.println(f.getName());
                f.delete();
            }
            newDirectory.delete();

        } catch (IOException e) {
            System.out.println("Some error occurred zip-archive creating");
        }
    }
}
