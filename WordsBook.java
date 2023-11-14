public class WordsBook {
    protected int perTimeLearn=20;
    protected Word[] words;
    protected String path;
    protected  String bookName;
    private int index;

    public Word getCurrent() {
        return words[index];
    }

    public boolean hasNext() {
        return index < words.length;
    }

    public Word next() {
        return words[++index];
    }
}
