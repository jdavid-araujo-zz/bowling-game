package util.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile implements Read {

    BufferedReader reader;

    @Override
    public void open(String path) {
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The file could not be opened");
        }
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't close file");
        }
    }

    @Override
    public String readNextLine() {
        try {
            String line = reader.readLine();
            if (line != null) {
                return line;
            }

            this.close();

            return null;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read the file");
        }
    }

    @Override
    public List<String> readlAll()  {
        List<String> data = new ArrayList<>();
        String line = "";

        while (line != null) {
             line = this.readNextLine();
             if(line != null) {
                 data.add(line);
             }
        }

        return data;
    }
}
