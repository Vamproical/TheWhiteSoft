package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ErrorCorrecting {
    public List<String> correct(List<String> textWithError, List<Replacements> replacements) {
        List<String> textWithoutError = new ArrayList<>();
        List<Replacements> uniqueReplacements = getUniqueReplacementsList(replacements);
        for (String str : textWithError) {
            List<Replacements> correcting = new ArrayList<>();
            for (Replacements r : uniqueReplacements) {
                if (str.contains(r.getReplacement())) {
                    correcting.add(r);
                }
            }
            correcting.sort((r1, r2) -> (-1) * Integer.compare(r1.getReplacement().length(), r2.getReplacement().length()));
            for (Replacements r : correcting) {
                if (r.getSource() != null) {
                    str = str.replace(r.getReplacement(), r.getSource());
                } else {
                    str = str.replace(r.getReplacement(), "");
                }
            }
            textWithoutError.add(str);
        }

        return textWithoutError.stream().filter(c -> !c.equals("")).collect(Collectors.toList());
    }

    private List<Replacements> getUniqueReplacementsList(List<Replacements> replacements) {
        Collections.reverse(replacements);
        return replacements.stream().distinct().collect(Collectors.toList());
    }
}
