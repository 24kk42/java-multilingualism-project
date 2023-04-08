import java.util.Random;

public class User {
    private String username;
    private String password;
    private ILanguage preferredLanguage;
    private Unit currentUnit;
    private int numberOfSolvedQuizzes;
    private int totalPoints=0;
    private int streak;
    private Random random = new Random();

    public User(String username, String password, ILanguage lang) {
        this.username = username ;
        this.password = password ;
        this.streak = random.nextInt(366);
        this.preferredLanguage = lang;
        this.numberOfSolvedQuizzes = random.nextInt(preferredLanguage.getTotalNumberOfQuizzes()-5) + 6;
    }

    public String getUsername() {
        return username;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ILanguage getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(ILanguage preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public Unit getCurrentUnit() {
        return currentUnit;
    }

    public int getNumberOfSolvedQuizzes() {
        return numberOfSolvedQuizzes;
    }

    public void setNumberOfSolvedQuizzes(int numberOfSolvedQuizzes) {
        this.numberOfSolvedQuizzes = numberOfSolvedQuizzes;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void solveQuizzes(){
        int quizzesLeft = this.numberOfSolvedQuizzes;
        for(Unit unit: this.preferredLanguage.getUnits()){
            if(quizzesLeft == 0){
                break;
            }
            this.currentUnit = unit;
            for(Quiz quiz: unit.getQuizzes()) {
                if (quizzesLeft == 0) {
                    break;
                }
                quizzesLeft -= 1;
                for (Question question : quiz.getQuestions()) {
                    boolean questionSolved = random.nextBoolean();
                    if (questionSolved) {
                        this.totalPoints += question.getQuestionPoint();
                    }
                }
            }
        }
    }
}
