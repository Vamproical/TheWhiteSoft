package assignment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> textWithError = FileUtils.readErrorText("src/main/resources/data.json");
        List<Replacements> replacements = FileUtils.readReplacementFile("src/main/resources/replacement.json");
        ErrorCorrecting errorCorrecting = new ErrorCorrecting();
        List<String> result = errorCorrecting.correct(textWithError, replacements);
        FileUtils.writeFile(result);
    }
}