package testing;

import app.LogWriter;

public class LogWriterTest {

    public static void main(String[] args) {

        System.out.println("--- Starting LogWriter Test ---\n");
        System.out.println("Check the logs files");

        LogWriter.add(
                "\n" +
                "Mean: 100s \n" +
                "Minimum: 10s \n" +
                "Maximum: 210s");

        System.out.println("\n---- Ending LogWriter Test ----");
    }

}
