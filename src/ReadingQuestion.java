public class ReadingQuestion extends Question {
    private String englishString;
    private String preferredLanguageString;

    public ReadingQuestion() {
        super("Reading", 10);
        this.englishString = generateRandomWord();
        this.preferredLanguageString = generateRandomWord();
    }

    public String getEnglishString() {
        return this.englishString;
    }

    public String getPreferredLanguageString() {
        return this.preferredLanguageString;
    }
}
