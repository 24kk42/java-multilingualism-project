public class WordMatchingQuestion extends Question{
    private String keyString;
    private String valueString;

    public WordMatchingQuestion() {
        super("Word-Matching", 5);
        this.keyString = generateRandomWord();
        this.valueString = generateRandomWord();
    }

    public String getKeyString() {
        return this.keyString;
    }

    public String getValueString() {
        return this.valueString;
    }
}
