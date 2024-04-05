import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // creating the file
        File newFile = createFile("bar");

        // writing to file
        String[] fileContents = {"Hola", "Amigxs!", "Deséenme", "Suerte!"};
        writeFile(newFile, fileContents);

        // reading the file
        readFile(newFile);

    }

    public static void writeFile(File file, String[] content) {
        //using try-with-resources here! o_0
        try (FileWriter fileWriter = new FileWriter(file, true); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (String word : content) {
                printWriter.println(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static File createFile(String file) {
        // CREATING / DELETING FILE
        String fileName = file.isBlank() ? "foo" : file;
        File newFile = new File(String.format("./files/src/%s.txt", fileName));
        try {
            if (!newFile.exists()) {
                System.out.printf("file created! %s.txt", fileName);
                newFile.createNewFile();
            }
            return newFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // reading files

    public static void readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);

            System.out.println("\n");
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
