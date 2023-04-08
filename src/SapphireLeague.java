import java.util.ArrayList;

public class SapphireLeague extends League{
    public SapphireLeague() {
        super("Sapphire");
    }

    @Override
    public void initializeLeague(ArrayList<User> previousLeague) {
        ArrayList<User> top5User = getTopX(5, previousLeague);
        for(User user: top5User){
            if(user.getStreak() >= 7) {
                previousLeague.remove(user);
                addUser(user);
            }
        }
    }
}
