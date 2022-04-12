package assignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ErrorCorrectingTest {
    @Test
    void checkCorrectMethod() {
        //arrange
        List<String> errorText = Arrays.asList(
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
        List<Replacements> replacements = Arrays.asList(
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
        List<String> exceptData = Arrays.asList(
                "Two roads diverged in a yellow wood,",
                "Robert Frost poetAnd sorry I could not travel both",
                "And be one traveler, long I stood",
                "And looked down one as far as I could",
                "To where it bent in the undergrowth;",
                "Then took the other, as just as fair,",
                "And having perhaps the better claim,",
                "Because it was grassy and wanted wear;",
                "Though as for that the passing there",
                "Had worn them really about the same,",
                "And both that morning equally lay",
                "In leaves no step had trodden black.",
                "Oh, I kept the first for another day!",
                "Yet  knowing how way leads on to way,",
                "I doubted if I should ever come back.",
                "I shall be telling this with a sigh",
                " Somewhere ages and ages hence:",
                "Two roads diverged in a wood, and I",
                "I took the one less traveled by,",
                "And that has made all the difference."
        );
        //Act
        ErrorCorrecting errorCorrecting = new ErrorCorrecting();
        List<String> result = errorCorrecting.correct(errorText, replacements);
        //Assert
        Assertions.assertEquals(exceptData, result);
    }

    @Test
    void checkCorrectMethodIfReplacementIsNotExist() {
        //arrange
        List<String> errorText = Arrays.asList(
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
        List<Replacements> replacements = new ArrayList<>();
        //act
        ErrorCorrecting errorCorrecting = new ErrorCorrecting();
        List<String> result = errorCorrecting.correct(errorText, replacements);
        //assert
        Assertions.assertEquals(errorText, result);
    }
}