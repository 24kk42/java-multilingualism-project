import java.util.ArrayList;
import java.util.Random;

public abstract class Language implements ILanguage {
    private String languageName;
    private ArrayList<Unit> units;
    private ArrayList<User> usersInLanguage;
    private Random random = new Random();
    private int randomCapacity;
    private ILeague bronzeLeague = new BronzeLeague();
    private ILeague silverLeague = new SilverLeague();
    private ILeague goldLeague = new GoldLeague();
    private ILeague sapphireLeague = new SapphireLeague();
    private ILeague rubyLeagueLeague = new RubyLeague();

    public ILeague getBronzeLeague() {
        return bronzeLeague;
    }

    public ILeague getSilverLeague() {
        return silverLeague;
    }

    public ILeague getGoldLeague() {
        return goldLeague;
    }

    public ILeague getSapphireLeague() {
        return sapphireLeague;
    }

    public ILeague getRubyLeague() {
        return rubyLeagueLeague;
    }

    public Language(String languageName) {
        this.languageName = languageName;
        int randomNumber = random.nextInt(41) + 60;
        this.units = new ArrayList<>(randomNumber);
        this.usersInLanguage = new ArrayList<>();
        this.randomCapacity =  randomNumber;
        generateUnits();
    }
    // Constructor override
    public Language(String languageName, int unitsSize) {
        this.languageName = languageName;
        this.units = new ArrayList<>(unitsSize);
        this.usersInLanguage = new ArrayList<>();
    }

    public ArrayList<Unit> getUnits() {
        return this.units;
    }

    public int getCountOfUnits() {
        return this.units.size();
    }

    public String getLanguageName() {
        return this.languageName;
    }

    public void addUser(User user){
        this.usersInLanguage.add(user);
    }

    public ArrayList<User> getUsersInLanguage(){
        return this.usersInLanguage;
    }

    public void setUnits(ArrayList<Unit> newUnits) {
        this.units.addAll(newUnits);
    }

    public void addUnit(Unit unit){
        this.units.add(unit);
    }

    public void generateUnits(){
        int numberOfUnits = this.randomCapacity;
        int unitNo = 1;
        ArrayList<Unit> copyUnits = new ArrayList<>(numberOfUnits);

        for(int i=0; i < numberOfUnits; i++) {
            Unit newUnit = new Unit(unitNo);
            unitNo++;
            copyUnits.add(newUnit);
        }
        this.units.addAll(copyUnits);
    }

    public int getTotalNumberOfQuizzes(){
        int numberOfQuizzes = 0;
        for (Unit unit : this.getUnits()){
            numberOfQuizzes += unit.countOfQuizzes();
        }
        return numberOfQuizzes;
    }

    public void initializeLeagues(){
        bronzeLeague.initializeLeague(usersInLanguage);
        silverLeague.initializeLeague(bronzeLeague.getUsersInLeague());
        goldLeague.initializeLeague(silverLeague.getUsersInLeague());
        sapphireLeague.initializeLeague(goldLeague.getUsersInLeague());
        rubyLeagueLeague.initializeLeague(sapphireLeague.getUsersInLeague());
    }
}
