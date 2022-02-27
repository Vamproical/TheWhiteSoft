package assignment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> textWithError = JsonUtils.getTextFromURL();
        //List<String> textWithError = FileUtils.readErrorText("src/main/resources/data.json");
        List<Replacements> replacements = JsonUtils.readReplacementFile("src/main/resources/replacement.json");
        ErrorCorrecting errorCorrecting = new ErrorCorrecting();
        JsonUtils.writeFile(errorCorrecting.correct(textWithError, replacements));
    }
}
