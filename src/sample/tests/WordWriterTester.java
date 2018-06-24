package sample.tests;

import sample.model.WordWriter;

public class WordWriterTester {
    public static void test(){
        addWord();
    }

    private static void addWord(){
        WordWriter.addWord("asdf");
    }
}
