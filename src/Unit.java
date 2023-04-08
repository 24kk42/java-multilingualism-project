import java.util.ArrayList;
import java.util.Random;

public class Unit {
    private int unitCount; //Unit 1, Unit 2...
    private Random random = new Random();
    private ArrayList<Quiz> quizzes;
    private int randomCapacity;

    public Unit(int unitCount){
        this.unitCount = unitCount;
        int randomNumber = random.nextInt(10) + 1;
        this.quizzes = new ArrayList<>(randomNumber);
        this.randomCapacity = randomNumber;
        generateQuizzes();
    }

    public Unit(int unitCount, int quizCount){
        this.unitCount = unitCount;
        this.quizzes = new ArrayList<>(quizCount);
        this.randomCapacity = quizCount;
    }

    public String getUnitCount() {
        return Integer.toString(this.unitCount);
    }

    public ArrayList<Quiz> getQuizzes() {
        return this.quizzes;
    }

    public int countOfQuizzes() {
        return this.quizzes.size();
    }

    public void setQuizzes(ArrayList<Quiz> newQuizzes) {
        this.quizzes.addAll(newQuizzes);
    }

    public void generateQuizzes() {
        int numberOfQuizzes = this.randomCapacity;
        ArrayList<Quiz> copyQuizzes = new ArrayList<>(numberOfQuizzes);
        int quizNo = 1;
        for(int i = 0; i < numberOfQuizzes ; i++) {
            Quiz newQuiz = new Quiz(quizNo);
            copyQuizzes.add(newQuiz);
            quizNo++;
        }
        this.quizzes.addAll(copyQuizzes);
    }

    public void addQuiz(Quiz quiz){
        this.quizzes.add(quiz);
    }


}
