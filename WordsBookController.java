import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

public class WordsBookController {
    public WordsBookController(Stage stage, WordsBook model, WordsBookView view) {
        view.button.setOnAction(event -> {

            try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/simpleEC.dct"),"GB2312")){
                if(!scanner.hasNextLine()){
                    System.err.println("Failed to load the dictionary");
                    return;
                }
                model.path="/simpleEC.dct";
                model.bookName="简明英汉词典";
                loadWords(model,scanner);
                scanner.close();
            } catch (Exception e) {
                System.err.println("Exception when get the dictionary");
            }
            WordView reciteView =new WordView(model);
            WordController reciteController = new WordController(reciteView,model);
            Scene scene = new Scene(reciteView,800,600);
            stage.setScene(scene);
            if(model.words[0]!=null)model.words[0].pronouns();
        });
        view.otherBook.setOnAction(event -> {

        });
    }
    private void loadWords(WordsBook model,Scanner scanner){
        model.words=new Word[model.perTimeLearn];
        int index=0;
        while (scanner.hasNextLine()&&index < model.perTimeLearn) {
            String line = scanner.nextLine();
            //↑目前是按顺序读取，未来可以随机。方法是while(isValid()){}...（到时候再写 只是表达意思  代码不准确）
            //需要读取学习信息 从另一个文件中读取
            String[] tmp = line.split("::");
            String[] tmp2 = tmp[1].split("\\.");
            model.words[index]=new Word(tmp[0],tmp2[1],tmp2[0]);
            System.out.println("load"+model.words[index]+" success");
            index++;
        }
        System.out.println("load "+model.perTimeLearn+" words in one time");
    }
}
