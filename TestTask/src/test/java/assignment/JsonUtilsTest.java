package assignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class JsonUtilsTest {

    @Test
    void readTextFromURL() {
        //arrange
        List<String> exceptData = Arrays.asList(
                "Two roads diverged in a yellow d12324344rgg6f5g6gdf2ddjf,",
                "Robert Frost poetAnd sorry I cou1d not trave1 both",
                "An other text",
                "And be one trave1er, long I stood",
                "And 1ooked down one as far as I cou1d",
                "Bla-bla-bla-blaaa, just some RANDOM tExT",
                "To where it bent in the undergrowth;",
                "Then Random text, yeeep the other, as just as fair,",
                "And having perhaps parentheses - that is a smart word,",
                "Bla-bla-bla-blaaa, just some RANDOM tExT",
                "Because it was grassy and wanted wear;",
                "An other text",
                "An other text",
                "Though as for that the passing there",
                "Emptry... or NOT! them rea11y about the same,",
                "And both that morning equally lay",
                "In 1eaves no step had trodden b1ack.",
                "Oh, I kept the first for another day!",
                "Yet Skooby-dooby-doooo 1eads on to way,",
                "Ha-haaa, hacked you.",
                "An other text",
                "I shall be te11ing this with a sigh",
                "sdshdjdskfm sfjsdif jfjfidjf",
                "Two roads diverged in a d12324344rgg6f5g6gdf2ddjf, and I",
                "I Random text, yeeep the one less traveled by,",
                "And that has made a11 the difference.",
                "Bla-bla-bla-blaaa, just some RANDOM tExT"
        );
        //act
        List<String> result = JsonUtils.getTextFromURL();
        //assert
        Assertions.assertEquals(exceptData, result);
    }

    @Test
    void readJsonFile() {
        //arrange
        List<String> exceptData = Arrays.asList(
                "Two roads diverged in a yellow d12324344rgg6f5g6gdf2ddjf,",
                "Robert Frost poetAnd sorry I cou1d not trave1 both",
                "An other text",
                "And be one trave1er, long I stood",
                "And 1ooked down one as far as I cou1d",
                "Bla-bla-bla-blaaa, just some RANDOM tExT",
                "To where it bent in the undergrowth;",
                "Then Random text, yeeep the other, as just as fair,",
                "And having perhaps parentheses - that is a smart word,",
                "Bla-bla-bla-blaaa, just some RANDOM tExT",
                "Because it was grassy and wanted wear;",
                "An other text",
                "An other text",
                "Though as for that the passing there",
                "Emptry... or NOT! them rea11y about the same,",
                "And both that morning equally lay",
                "In 1eaves no step had trodden b1ack.",
                "Oh, I kept the first for another day!",
                "Yet Skooby-dooby-doooo 1eads on to way,",
                "Ha-haaa, hacked you.",
                "An other text",
                "I shall be te11ing this with a sigh",
                "sdshdjdskfm sfjsdif jfjfidjf",
                "Two roads diverged in a d12324344rgg6f5g6gdf2ddjf, and I",
                "I Random text, yeeep the one less traveled by,",
                "And that has made a11 the difference.",
                "Bla-bla-bla-blaaa, just some RANDOM tExT"
        );
        //act
        List<String> result = JsonUtils.readJson("src/main/resources/data.json");
        //assert
        Assertions.assertEquals(exceptData, result);
    }

    @Test
    void checkReadJsonIfFileIsIncorrect() {
        String path = "src/main/resources/replacement.json";
        Assertions.assertThrows(UnsupportedOperationException.class, () -> JsonUtils.readJson(path));
    }

    @Test
    void checkReadJsonIfFileIsNotExist() {
        String path = "missing.json";
        List<String> exceptData = new ArrayList<>();
        List<String> result = JsonUtils.readJson(path);
        Assertions.assertEquals(exceptData, result);
    }

    @Test
    void readReplacementJsonFile() {
        List<Replacements> exceptData = Arrays.asList(
                new Replacements("Ha-haaa, hacked you", "I doubted if I should ever come back"),
                new Replacements("sdshdjdskfm sfjsdif jfjfidjf", "Somewhere ages and ages hence"),
                new Replacements("1", "l"),
                new Replacements("Emptry... or NOT!", null),
                new Replacements("d12324344rgg6f5g6gdf2ddjf", "wood"),
                new Replacements("Random text, yeeep", "took"),
                new Replacements("Bla-bla-bla-blaaa, just some RANDOM tExT", null),
                new Replacements("parentheses - that is a smart word", "the better claim"),
                new Replacements("sdshdjdskfm sfjsdif jfjfidjf", "Somewhere ages and ages hence:"),
                new Replacements("Emptry... or NOT!", "Had worn"),
                new Replacements("Skooby-dooby-doooo", " knowing how way leads on"),
                new Replacements("sdshdjdskfm sfjsdif jfjfidjf"," Somewhere ages and ages hence:"),
                new Replacements("An other text", null),
                new Replacements("Skooby-dooby-doooo"," knowing how way")
        );
        List<Replacements> result = JsonUtils.readReplacementFile("src/main/resources/replacement.json");
        Assertions.assertEquals(exceptData,result);
    }

    @Test
    void checkReadReplacementJsonFileIfFileIsIncorrect() {
        String path = "src/main/resources/data.json";
        Assertions.assertThrows(IllegalStateException.class, () -> JsonUtils.readReplacementFile(path));
    }

    @Test
    void checkReadReplacementJsonIfFileIsNotExist() {
        String path = "missing.json";
        List<Replacements> exceptData = new ArrayList<>();
        List<Replacements> result = JsonUtils.readReplacementFile(path);
        Assertions.assertEquals(exceptData, result);
    }
}