package assignment;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private JsonUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> getTextFromURL() {
        List<String> text = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://raw.githubusercontent.com/thewhitesoft/student-2022-assignment/main/data.json"))
                .GET()
                .build();
        try {
            var response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            JsonArray parser = JsonParser.parseString(response.body()).getAsJsonArray();
            for (JsonElement r : parser) {
                text.add(r.getAsString());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static List<String> readErrorText(String inputFile) {
        List<String> text = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            JsonArray parser = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement r : parser) {
                text.add(r.getAsString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return text;
    }

    public static List<Replacements> readReplacementFile(String inputFile) {
        List<Replacements> replacements = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(inputFile))) {
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
        try (Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/result.json"))) {
            Gson gson = new Gson();
            gson.toJson(correctText, writer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
