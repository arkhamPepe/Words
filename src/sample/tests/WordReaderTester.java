package sample.tests;

import sample.model.WordReader;
import sample.model.word.IWord;

import java.util.ArrayList;
import java.util.List;

public class WordReaderTester {
    public static void test(){
        WordReader.setWordFile("temp");
        printWords();
        printWordsAndDef();
    }

    private static void printWords(){
        List<IWord> words = WordReader.getWords();
        for (IWord word : words){
            System.out.println(word.getWord());
        }
    }
    private static void printWordsAndDef(){
        List<IWord> words = WordReader.getWords();
        for (IWord word : words){
            System.out.println(word.getWord());

            System.out.println("\tDefinitions:");
            for (String definition : word.getDefinitions()){
                System.out.println("\t\t" + definition);
            }
            System.out.println("\tSynonyms:");
            for (String synonym : word.getSynonyms()){
                System.out.println("\t\t" + synonym);
            }
        }
    }
}
