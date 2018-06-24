package sample.model.word;

import java.util.List;

public interface IWord {
    String getWord();
    List<String> getDefinitions();
    List<String> getSynonyms();
    void addDefinition(String definition);
    void addSynonym(String synonym);
    void setWord(String word);
}
