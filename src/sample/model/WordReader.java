package sample.model;

import sample.model.word.IWord;
import sample.model.word.WordFactory;

import java.util.ArrayList;
import java.util.List;

public class WordReader {
    private final static char DEFINITION_SIGN = '¤';
    private final static char SYNONYM_SIGN = '§';
    private final static String DEFAULT_PATH = System.getProperty("user.dir") + "\\src\\sample\\docs\\words.txt";
    private static TextFileReader reader = new TextFileReader(DEFAULT_PATH);
    private static List<IWord> words;

    /** Switches word-file to s.txt */
    public static void setWordFile(String s){
        reader.setFileReader(System.getProperty("user.dir") + "\\src\\sample\\docs\\" + s + ".txt");
    }

    /** Returns a List of all words in a word-file (.txt-file)*/
    public static List<IWord> getWords(){
        loadWords();
        return words;
    }
    public static List<String> getRows(){
        return reader.getRows();
    }

    /** Reads all rows in a word-file and extracts all definitions and synonyms for a word.
     *  All words are stored in a List */
    private static void loadWords(){
        IWord word;
        String temp;
        words = new ArrayList<>();

        reader.loadTextRows();

        // Create a new word, then add its definitions and synonyms, finally add the word to the list.
        for (String row : reader.getRows()){
            word = WordFactory.getNewWord(getWord(row));

            // Get all definitions for the current word
            for (String definition : StringHandler.getStringsBetweenChar(DEFINITION_SIGN, row)){
                word.addDefinition(definition);
            }
            // Get all synonyms...
            for (String synonym : StringHandler.getStringsBetweenChar(SYNONYM_SIGN, row)){
                word.addSynonym(synonym);
            }

            words.add(word);
        }
    }

    /** Returns the first word of a String */
    private static String getWord(String s){
        return s.substring(0, StringHandler.getFirstIndexOfChar(' ', s));
    }
}
