import java.io.IOException;
import java.util.ArrayList;

public class JsonLoader {
    private final JsonSettings settings = new JsonSettings();
    private final ArrayList<String> naches;

    public JsonLoader() throws IOException {
        this.naches = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hællæ");
        System.out.println(new JsonLoader().settings.filePath);
    }
}
