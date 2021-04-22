package functionality;

public class Word implements Comparable<Word> {
    private String word;

    Word(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(super.equals(obj)) return true;

        if(!(obj instanceof Word)) return false;

        Word object =(Word) obj;

        return word.equals(object.word);
    }

    public int compareTo(Word o) {
        if (word.equals("")) return 1;
        if (o.word.equals("")) return -1;
        return Character.toString(this.word.charAt(0)).compareTo(Character.toString(o.word.charAt(0)));
    }
}
