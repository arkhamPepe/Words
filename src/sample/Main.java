package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.TextFileReader;
import sample.tests.WordReaderTester;

public class Main extends Application {
    private static final String WORDS_PATH = System.getProperty("user.dir") + "\\src\\sample\\docs\\words.txt";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/frame.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1050, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        TextFileReader reader = new TextFileReader(WORDS_PATH);

        WordReaderTester.test();


        //launch(args);
    }
}
