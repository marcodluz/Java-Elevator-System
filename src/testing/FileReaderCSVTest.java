package testing;

import java.io.File;

import app.FileReaderCSV;

public class FileReaderCSVTest {

    // Location of the file for test
    static String file = "src/db/CallList1.csv";

    public static void main(String[] args) {

        System.out.println("--- Starting FileReader Test ---\n");

        testFileRead();
        testFileContents();

        System.out.println("\n---- Ending FileReader Test ----");

    }

    // Test if the file can be read
    public static void testFileRead() {

        try {
            File fileTest = new File(file);
            fileTest.createNewFile();
            System.out.println("The file can be read? " + fileTest.canRead());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Output the file contents to check if its getting accurate reading
    public static void testFileContents() {
        System.out.println("\nFile contents:");

        FileReaderCSV fileReaderCSV = new FileReaderCSV(file);
        fileReaderCSV.readFile();
        fileReaderCSV.listFileContents();
    }

}
