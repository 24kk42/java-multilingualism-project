import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public  class FileIO {

    public ArrayList<ArrayList<String>> readLines() throws IOException {
        try {
            ArrayList<ArrayList<String>> lines=new ArrayList<>();
            String relativePath = "users.csv";
            FileReader fileReader = new FileReader(relativePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine()) != null){
                ArrayList<String> lineArray = new ArrayList<>();
                for (int i = 0 ; i < line.split(";").length ; i++){
                    lineArray.add(line.split(";")[i]);
                }
                lines.add(lineArray);
            }
            bufferedReader.close();
            return lines;
        }
        catch (IOException e){
            System.out.println("File error.");
            System.exit(0);
            return null;
        }
    }
}
