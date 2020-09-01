package util.reader;

import java.util.List;

public interface Read {

    void open(String path);

    void close();

    String readNextLine();

    List<String> readlAll();
}
