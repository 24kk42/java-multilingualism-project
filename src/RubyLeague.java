import java.util.ArrayList;

public class RubyLeague extends League{
    public RubyLeague() {
        super("Ruby");
    }

    @Override
    public void initializeLeague(ArrayList<User> previousLeague) {
        for(User user : previousLeague){
            if(user.getTotalPoints() > 5000 && user.getStreak() >= 30){
                addUser(user);
            }
            else if(Integer.parseInt(user.getCurrentUnit().getUnitCount()) >= 10){
                addUser(user);
            }
        }

        for(User user : getUsersInLeague()){
            previousLeague.remove(user);
        }
    }
}
