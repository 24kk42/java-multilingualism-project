public class ListeningQuestion extends Question{
    private String englishString;
    private int audio;

    public ListeningQuestion() {
        super("Listening", 7);
        this.englishString = generateRandomWord();
        this.audio = generateRandomLengthForAudio();
    }

    public String getEnglishString() {
        return this.englishString;
    }

    public int getAudio() {
        return this.audio;
    }
}
