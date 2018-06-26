package sample.tests;

import sample.model.WordReader;
import sample.model.WordWriter;

public class WordWriterTester {
    public static void test(){


        editWord("asdf", "movie");
    }

    private static void addWord(){
        WordWriter.addWord("asdf");
    }

    private static void editWord(String oldWord, String newWord){
        WordReader.setWordFile("temp");
        WordWriter.replaceWord(oldWord, newWord);
    }
}
