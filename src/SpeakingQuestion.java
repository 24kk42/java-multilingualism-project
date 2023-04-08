public class SpeakingQuestion extends Question{
    private int audio1 ;
    private int audio2 ;

    public SpeakingQuestion() {
        super("Speaking", 8);
        this.audio1 = generateRandomLengthForAudio();
        this.audio2 = generateRandomLengthForAudio();
    }

    public int getAudio1() {
        return this.audio1;
    }

    public int getAudio2() {
        return this.audio2;
    }
}
