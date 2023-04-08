import java.util.ArrayList;

public interface ILanguage {
    public ArrayList<Unit> getUnits();

    public int getCountOfUnits();

    public String getLanguageName();

    public void setUnits(ArrayList<Unit> newUnits);

    public void generateUnits();

    public void addUnit(Unit unit);

    public int getTotalNumberOfQuizzes();

    public void addUser(User user);

    public ArrayList<User> getUsersInLanguage();

    public void initializeLeagues();

    public ILeague getBronzeLeague();

    public ILeague getSilverLeague();

    public ILeague getGoldLeague();

    public ILeague getSapphireLeague();

    public ILeague getRubyLeague();
}
