package sample.model;

import sample.model.word.IWord;
import sample.model.word.WordFactory;

import java.util.Random;

public class WordWriter {
    private final static char DEFINITION_SIGN = '¤';
    private final static char SYNONYM_SIGN = '§';
    private final static String DEFAULT_PATH = System.getProperty("user.dir") + "\\src\\sample\\docs\\temp.txt";
    private static TextFileWriter writer = new TextFileWriter(DEFAULT_PATH);

    public static void addWord(IWord word){
        StringBuilder sb = new StringBuilder();

        sb.append(word.getWord() + " ");

        for (String definition : word.getDefinitions()){
            sb.append(DEFINITION_SIGN + definition + DEFINITION_SIGN);
        }
        for (String synonym : word.getSynonyms()){
            sb.append(SYNONYM_SIGN + synonym + SYNONYM_SIGN);
        }

        writer.writeToFile(sb.toString());
    }

    public static void addWord(String s){
        IWord word = WordFactory.getNewWord(s);
        word.addSynonym("synonym" + new Random().nextInt(100));
        word.addDefinition("definition" + new Random().nextInt(100));
        addWord(word);
    }
}
