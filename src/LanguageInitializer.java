import java.util.ArrayList;

public class LanguageInitializer {
    private ArrayList<ILanguage> languages ;

    public LanguageInitializer(){
        languages = new ArrayList<>(4);
        ILanguage turkish = new Turkish();
        ILanguage german = new German();
        ILanguage italian = new Italian();
        ILanguage spanish = new Spanish();

        languages.add(turkish);
        languages.add(german);
        languages.add(italian);
        languages.add(spanish);
    }

    public ArrayList<ILanguage> getLanguages() {
        return this.languages;
    }
}
