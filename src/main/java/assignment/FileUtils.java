package assignment;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private FileUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> readTextWithError(String inputFile) {
        List<String> text = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(inputFile));) {
            JsonArray parser = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement r : parser) {
                text.add(r.getAsString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return text;
    }

    public static List<Replacements> readFile(String inputFile) {
        List<Replacements> replacements = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(inputFile));) {
            JsonArray parser = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement r : parser) {
                String replacement = r.getAsJsonObject().get("replacement").getAsString();
                String source = r.getAsJsonObject().get("source").isJsonNull() ?
                        null : r.getAsJsonObject().get("source").getAsString();
                replacements.add(new Replacements(replacement, source));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return replacements;
    }

    public static void writeFile(List<String> correctText) {
        try (Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/result.json"));) {
            Gson gson = new Gson();
            gson.toJson(correctText, writer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
