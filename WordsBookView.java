import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class WordsBookView extends BorderPane {
    protected Button button=new Button("开始学习");
    protected Button otherBook=new Button("选择其他词书");
    private VBox box = new VBox(20);
    public WordsBookView(){
        box.getChildren().addAll(button,otherBook);
        box.setAlignment(Pos.CENTER);
        setCenter(box);
    }
}
