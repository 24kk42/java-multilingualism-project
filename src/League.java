import java.util.ArrayList;
import java.util.Collections;

public abstract class League implements ILeague {
    private ArrayList<User> users ;
    private String leagueName;

    public League(String leagueName){
        this.leagueName = leagueName;
        this.users = new ArrayList<>();
    }

    public ArrayList<User> getTopX(int topX, ArrayList<User> previousLeague){
        ArrayList<User> sortedUsers = new ArrayList<>(previousLeague);

        // Sort the users by their total points in descending order
        Collections.sort(sortedUsers, (a, b) -> b.getTotalPoints() - a.getTotalPoints());

        // Return the top X users, or all the users if there are less than X
        return new ArrayList<>(sortedUsers.subList(0, Math.min(topX, sortedUsers.size())));
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public ArrayList<User> getUsersInLeague(){
        return this.users;
    }
}
