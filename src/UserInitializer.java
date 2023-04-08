import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class UserInitializer {
    private ArrayList<User> users ;
    private FileIO fileIO = new FileIO();
    private Random random = new Random();
    private CSVReader languages ;

    public UserInitializer(CSVReader csvReader) throws IOException {
        this.users = new ArrayList<>();
        this.languages = csvReader;
        for (ArrayList<String> userCredentials : fileIO.readLines()) {
            int randomNumber = random.nextInt(4);
            User newUser = new User(userCredentials.get(0), userCredentials.get(1), languages.getLanguages().get(randomNumber));
            newUser.solveQuizzes();
            users.add(newUser);
            languages.getLanguages().get(randomNumber).addUser(newUser);
        }
    }

    public ArrayList<User> getUsers(){
        return this.users;
    }
}
