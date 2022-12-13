package app;

public class Main
{
    public static void main(String[] args)
    {
        FileReaderCSV fileReaderCSV = new FileReaderCSV("src/db/CallList1.csv");
        fileReaderCSV.readFile();

        // Call algorithm
        SimpleAlgorithm simpleAlgorithm = new SimpleAlgorithm();


        // Please call each one at the time //

        simpleAlgorithm.start("src/db/CallList1.csv");
        //simpleAlgorithm.start("src/db/CallList2.csv");
        //simpleAlgorithm.start("src/db/CallList3.csv");
    }
}