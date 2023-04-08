import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWriter {

    public CSVWriter(String csvPath, File csvFile, ArrayList<ILanguage> languages) {
        try {
            FileWriter fileWriter = new FileWriter(csvFile,true);
            for (ILanguage lang : languages) {
                String languageName = lang.getLanguageName();
                fileWriter.append(languageName);
                fileWriter.append(",");
                for(Unit unit : lang.getUnits()){
                    fileWriter.append("Unit");
                    fileWriter.append(" "+unit.getUnitCount());
                    fileWriter.append(",");
                    for(Quiz quiz : unit.getQuizzes()){
                        fileWriter.append("Quiz" + " " +quiz.getQuizCount() + "," + quiz.getQuizInformativeText() + ",");
                    }
                }
                fileWriter.append("\n");
            }
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
