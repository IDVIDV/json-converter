package example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public String readFile(Path path) throws IOException {
        return Files.readString(path);
    }
}
