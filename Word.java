import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory;
import java.io.*;
import java.net.URL;

public class Word {
    private String word;
    private String chinese;
    private String property;
    protected float familiar;
    protected  int learned;

    public void pronouns() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
       // InputStream dictionary = TextToSpeech.class.getResourceAsStream("/com/sun/speech/freetts/en/us/cmu_us_kal/cmudict04a");
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice("kevin16");
        if (voice != null) {
            voice.allocate();
            voice.speak(word);
            voice.deallocate();
        } else {
            System.err.println("Cannot find kevin16 voice");
        }
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", chinese='" + chinese + '\'' +
                ", property='" + property + '\'' +
                '}';
    }

    public String getWord() {
        return word;
    }

    public String getChinese() {
        return chinese;
    }

    public String getProperty() {
        return property;
    }

    public Word(String word, String chinese, String property) {
        this.word = word;
        this.chinese = chinese;
        this.property = property;
    }

    public boolean isLearned() {
        return learned != 0;
    }
}
