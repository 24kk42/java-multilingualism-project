import java.util.ArrayList;

public class BronzeLeague extends League{
    public BronzeLeague() {
        super("Bronze");
    }

    @Override
    public void initializeLeague(ArrayList<User> previousLeague) {
        this.getUsersInLeague().addAll(previousLeague);
    }
}
