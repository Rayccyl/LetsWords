import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/*
 * Created by WuSongYe on 2023/11/13
 * Default (Template) Project
 */
public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("Welcome to LetsWords\nLoading...");
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        WordsBook modelBook = new WordsBook();
        WordsBookView viewEnter = new WordsBookView();
        WordsBookController controller = new WordsBookController(primaryStage,modelBook, viewEnter);
        Scene scene = new Scene(viewEnter, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PhotoViewer");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
        primaryStage.show();
    }
}