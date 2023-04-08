import java.util.ArrayList;
import java.util.Random;

public class Quiz {
    private int quizCount ;
    private ArrayList<Question> questions;
    private Random random = new Random();
    private int randomCapacity;

    public Quiz(int quizCount) {
        this.quizCount = quizCount;
        int questionCount = random.nextInt(8) + 8;
        questions = new ArrayList<>(questionCount);
        this.randomCapacity = questionCount;
        generateQuestions();
    }

    public Quiz(int quizCount, int readingQuestionCount, int listeningQuestionCount, int speakingQuestionCount, int wordMatchingCount){
        this.quizCount = quizCount;
        questions = new ArrayList<>();
        int[] questionCounts = {readingQuestionCount, listeningQuestionCount, speakingQuestionCount, wordMatchingCount};
        this.createQuestions(questionCounts);
    }

    public ArrayList<Question> getQuestions(){
        return this.questions;
    }

    public int getQuestionCount(){
        return this.questions.size();
    }

    public String getQuizCount(){
        return Integer.toString(this.quizCount);
    }

    private void createQuestions(int[] questionCounts){
        ArrayList<Question> copyQuestions = new ArrayList<>();
        for(int i = 0; i< questionCounts[0];i++){
            ReadingQuestion readingQuestion = new ReadingQuestion();
            copyQuestions.add(readingQuestion);
        }
        for(int j = 0; j < questionCounts[1]; j++){
            ListeningQuestion listeningQuestion = new ListeningQuestion();
            copyQuestions.add(listeningQuestion);
        }
        for(int k = 0 ; k < questionCounts[2]; k++){
            SpeakingQuestion speakingQuestion = new SpeakingQuestion();
            copyQuestions.add(speakingQuestion);
        }
        for(int j = 0; j< questionCounts[3]; j++){
            WordMatchingQuestion wordMatchingQuestion = new WordMatchingQuestion();
            copyQuestions.add(wordMatchingQuestion);
        }
        this.questions.addAll(copyQuestions);
    }

    private void generateQuestions(){
        int questionCount = randomCapacity;
        ArrayList<Question> newQuestions = new ArrayList<>(questionCount);
        for(int i = 0; i < questionCount; i++) {
            int questionType = random.nextInt(4);
            switch (questionType){
                case 0:
                    ReadingQuestion readingQuestion = new ReadingQuestion();
                    newQuestions.add(readingQuestion);
                    break;
                case 1:
                    ListeningQuestion listeningQuestion = new ListeningQuestion();
                    newQuestions.add(listeningQuestion);
                    break;
                case 2:
                    SpeakingQuestion speakingQuestion = new SpeakingQuestion();
                    newQuestions.add(speakingQuestion);
                    break;
                case 3:
                    WordMatchingQuestion wordMatchingQuestion = new WordMatchingQuestion();
                    newQuestions.add(wordMatchingQuestion);
                    break;
            }
        }
        this.questions.addAll(newQuestions);
    }

    public String getQuizInformativeText() {
        int numberOfReadingQuestions = 0 ;
        int numberOfListeningQuestions = 0 ;
        int numberOfSpeakingQuestions = 0 ;
        int numberOfWordMatchingQuestions = 0 ;

        for (Question question : this.questions) {
            switch (question.getQuestionType()){
                case "Reading" :
                    numberOfReadingQuestions++;
                    break;
                case "Listening" :
                    numberOfListeningQuestions++;
                    break;
                case "Speaking" :
                    numberOfSpeakingQuestions++;
                    break;
                case "Word-Matching" :
                    numberOfWordMatchingQuestions++;
                    break;
            }
        }

        return numberOfReadingQuestions + "R:" + numberOfListeningQuestions + "L:" + numberOfSpeakingQuestions + "S:" + numberOfWordMatchingQuestions + "W" ;
    }
}
