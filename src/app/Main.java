package app;

public class Main
{
    public static void main(String[] args)
    {
        FileReaderCSV fileReaderCSV = new FileReaderCSV("src/db/CallList1.csv");
        fileReaderCSV.readFile();
        fileReaderCSV.listFileContents();
    }
}