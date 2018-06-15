package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.TextFileReader;

public class Main extends Application {
    private static final String WORDS_PATH = System.getProperty("user.dir") + "\\src\\sample\\docs\\words.txt";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        TextFileReader reader = new TextFileReader(WORDS_PATH);


        launch(args);
    }
}
