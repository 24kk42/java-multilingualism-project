import java.util.ArrayList;

public class SilverLeague extends League{
    public SilverLeague() {
        super("Silver");
    }

    @Override
    public void initializeLeague(ArrayList<User> previousLeague) {
        ArrayList<User> top15User = getTopX(15, previousLeague);
        for(User user: top15User){
            previousLeague.remove(user);
            addUser(user);
        }
    }
}
