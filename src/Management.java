import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Management {
    private final String csvPath = "languages.csv" ;
    private final File csvFile = new File(csvPath);
    private CSVReader languages;
    private CSVWriter csvWriter;
    UserInitializer userInitializer;

    public Management() throws IOException {
        createCSV(csvFile.exists() && csvFile.isFile());
        this.languages = new CSVReader(csvPath);
        this.userInitializer = new UserInitializer(languages);
        initializeLeagues();
        getHighestPointsUser();
        mostAdvancedInGerman();
        languageHasMostUnits();
        languageHasMostQuizzes();
        top3ItalianSilverLeague();
    }

    private void createCSV(boolean fileExists){
        if (!fileExists) {
            LanguageInitializer languageInitializer = new LanguageInitializer();
            csvWriter = new CSVWriter(csvPath, csvFile, languageInitializer.getLanguages());
        }
    }

    private void initializeLeagues(){
        for(ILanguage lang : languages.getLanguages()){
            lang.initializeLeagues();
        }
    }

    private void getHighestPointsUser(){
        int maxPoints = 0;
        User maxPointsUser = null;
        for(User user: userInitializer.getUsers()){
            int totalPoints = user.getTotalPoints();
            if (totalPoints > maxPoints) {
                maxPoints = totalPoints;
                maxPointsUser = user;
            }
        }
        System.out.println("1- "+maxPointsUser.getUsername() + " " + maxPoints + " points");
    }

    private void mostAdvancedInGerman(){
        int maxUnitCount= 0;
        User maxUnitCountUser = null;
        for (User user: languages.getLanguages().get(1).getUsersInLanguage()){
            int unitCount = Integer.parseInt(user.getCurrentUnit().getUnitCount());
            if (unitCount > maxUnitCount){
                maxUnitCount = unitCount;
                maxUnitCountUser = user;
            }
        }
        System.out.println("2- " + maxUnitCountUser.getUsername() + " Unit " + maxUnitCount);
    }

    private void languageHasMostUnits(){
        int maxNumberOfUnits = 0;
        ILanguage lang = null;
        for (ILanguage mockLang: languages.getLanguages()){
            int numberOfUnits = mockLang.getUnits().size();
            if (numberOfUnits > maxNumberOfUnits) {
                maxNumberOfUnits = numberOfUnits;
                lang = mockLang;
            }
        }
        System.out.println("3- "+ lang.getLanguageName() + " " + maxNumberOfUnits + " Units");
    }

    private void languageHasMostQuizzes(){
        int maxNumberOfQuizzes = 0;
        ILanguage lang = null;
        for (ILanguage mockLang: languages.getLanguages()){
            int numberOfQuizzes = mockLang.getTotalNumberOfQuizzes();
            if (numberOfQuizzes > maxNumberOfQuizzes) {
                maxNumberOfQuizzes = numberOfQuizzes;
                lang = mockLang;
            }
        }
        System.out.println("4- "+ lang.getLanguageName() + " " + maxNumberOfQuizzes + " Quizzes");
    }

    private void top3ItalianSilverLeague(){
        ArrayList<User> top3 = languages.getLanguages().get(2).getSilverLeague().getTopX(3, languages.getLanguages().get(2).getSilverLeague().getUsersInLeague());
        System.out.println("5- Italian Silver League Top 3: " + "1." + top3.get(0).getUsername() + " 2." + top3.get(1).getUsername() + " 3." + top3.get(2).getUsername());
    }



}
