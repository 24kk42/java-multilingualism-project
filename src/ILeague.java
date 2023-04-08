import java.util.ArrayList;

public interface ILeague {
    public void initializeLeague(ArrayList<User> previousLeague);
    public ArrayList<User> getTopX(int x, ArrayList<User> previousLeague);
    public void addUser(User user);
    public ArrayList<User> getUsersInLeague();
}
