package assignment;

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
}
