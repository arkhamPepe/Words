package sample.model.word;

import java.util.ArrayList;
import java.util.List;

class Word implements IWord {
    private String word;
    private List<String> synonyms;
    private List<String> definitions;

    protected Word(String word) {
        this.word = word;
        this.synonyms = new ArrayList<>();
        this.definitions = new ArrayList<>();
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public List<String> getDefinitions() {
        return getListCopy(definitions);
    }

    @Override
    public List<String> getSynonyms() {
        return getListCopy(synonyms);
    }

    @Override
    public void addDefinition(String definition) {
        this.definitions.add(definition);
    }

    @Override
    public void addSynonym(String synonym) {
        this.synonyms.add(synonym);
    }

    @Override
    public void setWord(String word) {
        this.word = word;
    }

    private <T> List<T> getListCopy(List<T> list) {
        List<T> copyList = new ArrayList<>();

        for(T item : list){
            copyList.add(item);
        }

        return copyList;
    }
}
