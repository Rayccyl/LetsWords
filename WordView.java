import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WordView extends BorderPane {
    HBox topBox = new HBox(10);
    Button backButton = new Button();
    ProgressBar progressBar = new ProgressBar();
    Button pronoucesButton=new Button();
    Label theWord=new Label();
    Label chinese=new Label();
    VBox centerBox = new VBox(20);
    HBox buttonsBox = new HBox(20);
    Button knowButton = new Button("认识");
    Button unfamiliarButton = new Button("不认识");
    Button vagueButton = new Button("模糊");
    public WordView(WordsBook model) {
        pronoucesButton.setScaleX(0.2);
        pronoucesButton.setScaleY(0.2);
        buttonsBox.getChildren().addAll(knowButton,unfamiliarButton,vagueButton);
        buttonsBox.setAlignment(Pos.CENTER);
        backButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/back.png"))));
        backButton.setAlignment(Pos.TOP_LEFT);
        pronoucesButton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/play.png"))));
        topBox.getChildren().addAll(backButton,progressBar);
        centerBox.getChildren().addAll(pronoucesButton,theWord,chinese);
        centerBox.setAlignment(Pos.CENTER);
        progressBar.setProgress(0);
        progressBar.setPrefWidth(720);
        setTop(topBox);
        setCenter(centerBox);
        setBottom(buttonsBox);
        if (model.words!=null){
            theWord.setText(model.words[0].getProperty()+"."+model.words[0].getWord());
            chinese.setText(model.words[0].getChinese());
        }
        theWord.setStyle("-fx-font-size: 24;");
        chinese.setStyle("-fx-opacity: 0;");
    }
}
