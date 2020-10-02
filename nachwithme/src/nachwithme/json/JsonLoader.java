package nachwithme.json;

import nachwithme.core.Nach;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonLoader {
    private final String filePath;
    private final Writer file;
    private final ArrayList<Nach> naches;

    public JsonLoader() throws IOException {
        this.filePath = "./src/main/resources/nachwithme/data/gson.json";
        this.file = Files.newBufferedWriter(Paths.get(this.filePath));
        this.naches = new ArrayList<>();
    }
}
