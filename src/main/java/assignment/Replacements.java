package assignment;

import java.util.Objects;

public class Replacements {
    private final String replacement;
    private final String source;

    public Replacements(final String replacement, final String source) {
        this.replacement = replacement;
        this.source = source;
    }

    public String getReplacement() {
        return replacement;
    }

    public String getSource() {
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Replacements that = (Replacements) o;
        return Objects.equals(replacement, that.replacement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replacement);
    }
}
