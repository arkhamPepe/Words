package sample.model.word;

public class WordFactory {
    public static IWord getNewWord(String word){
        return new Word(word);
    }
}
