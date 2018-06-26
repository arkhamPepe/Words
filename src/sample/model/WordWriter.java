package sample.model;

import sample.model.word.IWord;
import sample.model.word.WordFactory;

import java.util.List;
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

    public static void replaceWord(String oldWord, String newWord){
        /** 2 ways:
         * 1) read entire file, get all the lines, replace one line, overwrite file with new lines
         * 2) search entire file for specific line, edit that line directly in the file
         *
         * This method uses the 1st way.
         * */

        List<String> words = WordReader.getRows();
        String newLine;
        int firstWordLength;
        String firstWord;

        for (int i = 0; i < words.size(); i++){
            firstWord = StringHandler.getFirstWord(words.get(i));

            if (oldWord.equals(firstWord)) {
                // Read the old line of text
                newLine = words.get(i);

                // Keep all characters except the first word
                firstWordLength = firstWord.length();


                newLine = newLine.substring(firstWordLength);

                // Put the new word in the new line
                newLine = newWord + newLine;

                // Replace old line with the new line
                words.set(i, newLine);
            }
        }

        writer.setFileWriter(DEFAULT_PATH, false);
        writer.writeToFile(words);
        writer.setFileWriter(DEFAULT_PATH, true);
    }

    private static int getRowIndex(String word){
        List<String> words = WordReader.getRows();
        for (int i = 0; i < words.size(); i++){
            if (word == words.get(i))
                return i;
        }
        return -1;
    }
}
