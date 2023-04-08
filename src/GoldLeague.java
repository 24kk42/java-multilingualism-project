import java.util.ArrayList;

public class GoldLeague extends League{
    public GoldLeague() {
        super("Gold");
    }

    @Override
    public void initializeLeague(ArrayList<User> previousLeague) {
        ArrayList<User> top10User = getTopX(10, previousLeague);
        for(User user: top10User){
            previousLeague.remove(user);
            addUser(user);
        }
    }
}
