package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderCSV extends Reader {

    String file = "";
    String delimiter = ",";
    String line;
    List<List<String>> lines = new ArrayList();

    public FileReaderCSV(String file) {
        this.file = file;
    }

    public void readFile() {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                List<String> values = Arrays.asList(line.split(delimiter));
                lines.add(values);
            }
            //lines.forEach(l -> System.out.println(l));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void listFileContents () {
        lines.forEach(l -> System.out.println(l));
    }


    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
