import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
public class WordController {
    public WordController(WordView reciteView, WordsBook model) {
        reciteView.knowButton.setOnAction(event -> {
            Word word = model.getCurrent();
            nextWord(reciteView,model);
            word.learned++;
            word.familiar++;
            reciteView.chinese.setStyle("-fx-opacity: 0;");
        });

        reciteView.pronoucesButton.setOnAction(event -> {
            model.getCurrent().pronouns();
        });
        reciteView.setFocusTraversable(true);
        reciteView.requestFocus();
        reciteView.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                fadeInPauseAndOut(reciteView.chinese, () -> {});
            }
        });
    }
public void nextWord(WordView reciteView, WordsBook model) {
    fadeInPauseAndOut(reciteView.chinese, () -> {
        if (model.hasNext()) {
            Word word = model.next();
            reciteView.theWord.setText(word.getProperty() + "." + word.getWord());
            reciteView.chinese.setText(word.getChinese());
            new Thread(() -> word.pronouns()).start();
        }
    });
}

    private void fadeInPauseAndOut(Label chineseLabel, Runnable onComplete) {
        FadeTransition fadeInTransition = new FadeTransition(Duration.millis(500), chineseLabel);
        fadeInTransition.setFromValue(0.0);
        fadeInTransition.setToValue(1.0);

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(0.5));

        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(1), chineseLabel);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        SequentialTransition sequentialTransition = new SequentialTransition(fadeInTransition, pauseTransition, fadeOutTransition);
        sequentialTransition.setOnFinished(event -> onComplete.run());
        sequentialTransition.play();
    }

}
