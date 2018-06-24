package sample.tests;

import sample.model.WordReader;
import sample.model.word.IWord;

import java.util.ArrayList;
import java.util.List;

public class WordReaderTester {
    public static void test(){
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

            System.out.println("\n\tDefinitions:");
            for (String definition : word.getDefinitions()){
                System.out.println("\t\t" + definition);
            }
            System.out.println("\n\tSynonyms:");
            for (String synonym : word.getSynonyms()){
                System.out.println("\t\t" + synonym);
            }
        }
    }
}
