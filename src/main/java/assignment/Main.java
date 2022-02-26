package assignment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> textWithError = FileUtils.readTextWithError("src/main/resources/data.json");
        List<Replacements> replacements = FileUtils.readFile("src/main/resources/replacement.json");
        ErrorCorrecting errorCorrecting = new ErrorCorrecting();
        List<String> result = errorCorrecting.correct(textWithError, replacements);
        FileUtils.writeFile(result);
    }
}
