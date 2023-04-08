import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    private ArrayList<ILanguage> languages;
    private String languagesFilePath;

    public CSVReader(String path) {
        this.languagesFilePath = path;
        this.languages = new ArrayList<>();
        this.readFile();
    }

    public ArrayList<ILanguage> getLanguages() {
        return this.languages;
    }

    private void readFile() {
        try {
            BufferedReader buffreader = new BufferedReader(new FileReader(this.languagesFilePath));
            String newLine;
            while ((newLine = buffreader.readLine()) != null) {
                String[] lineArr = newLine.split(",");
                String langName = lineArr[0];
                int[] unitQuizCounts = getUnitandQuizCount(lineArr);
                int unitCount = unitQuizCounts[0];
                int quizCount = unitQuizCounts[1];
                Language lang = createLanguage(langName, unitCount);
                createUnits(lineArr, lang);
                this.languages.add(lang);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Language createLanguage(String languageName, int unitSize) {
        return switch (languageName) {
            case "Turkish" -> new Turkish(unitSize);
            case "German" -> new German(unitSize);
            case "Italian" -> new Italian(unitSize);
            case "Spanish" -> new Spanish(unitSize);
            default -> null;
        };
    }

    private void createUnits(String[] lineArr, Language lang){
        Quiz quiz;
        Unit unit = null;
        for (int i = 0 ; i < lineArr.length ; i++){
            String strToken = lineArr[i];
            if(strToken.contains("Unit")){
                int quizCountForUnit = 0;
                for(int j = i+1 ; j < i+11 && j < lineArr.length ; j++){
                    if (lineArr[j].contains("Quiz")){
                        quizCountForUnit++;
                    }
                    else if (lineArr[j].contains("Unit")){
                        break;
                    }
                }
                unit = new Unit(Integer.valueOf(strToken.split(" ")[1]), quizCountForUnit);
                lang.addUnit(unit);
            }
            else if(strToken.contains("Quiz")){
                String[] questionsTokenArr = lineArr[i+1].split(":");
                quiz = new Quiz(Integer.valueOf(strToken.split(" ")[1]),
                        Integer.parseInt(questionsTokenArr[0].substring(0, questionsTokenArr[0].length() -1)),
                        Integer.parseInt(questionsTokenArr[1].substring(0, questionsTokenArr[1].length() -1)),
                        Integer.parseInt(questionsTokenArr[2].substring(0, questionsTokenArr[2].length() -1)),
                        Integer.parseInt(questionsTokenArr[3].substring(0, questionsTokenArr[3].length() -1))
                        );
                unit.addQuiz(quiz);
            }
        }

    }

    private int[] getUnitandQuizCount(String[] lineArr){
        int unitCount = 0;
        int quizCount = 0;
        for (String token : lineArr) {
            if (token.contains("Unit")) {
                unitCount++;
            } else if (token.contains("Quiz")) {
                quizCount++;
            }
        }
        return new int[]{unitCount, quizCount};
    }
}
