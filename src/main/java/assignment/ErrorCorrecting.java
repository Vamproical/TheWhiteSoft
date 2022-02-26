package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ErrorCorrecting {
    public List<String> correct(List<String> textWithError, List<Replacements> replacements) {
        List<String> textWithoutError = new ArrayList<>();

        for (String str : textWithError) {
            String result = str;
            for (Replacements r : replacements) {
                if (str.contains(r.getReplacement())) {
                    if (r.getSource() != null) {
                        result = str.replace(r.getReplacement(), r.getSource());
                    } else {
                        result = str.replace(r.getReplacement(), "");
                    }
                }
            }
            textWithoutError.add(result);
        }

        return textWithoutError.stream().filter(c -> !c.equals("")).collect(Collectors.toList());
    }
}
