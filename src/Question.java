import java.util.Random;

public abstract class Question {
    private String questionType;
    private int questionPoint;
    private Random random = new Random();

    public Question(String questionType, int questionPoint) {
        this.questionType = questionType;
        this.questionPoint = questionPoint;
    }

    public String getQuestionType() {
        return this.questionType;
    }

    public int getQuestionPoint() {
        return this.questionPoint;
    }

    public String generateRandomWord() {
        int length = random.nextInt(8) + 3; // generate random length between 3 and 10

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // generate a random letter from the English alphabet
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }

    public int generateRandomLengthForAudio() {
        int length = random.nextInt(46) + 15; //A Length in seconds between 15-60
        return  length;
    }
}
