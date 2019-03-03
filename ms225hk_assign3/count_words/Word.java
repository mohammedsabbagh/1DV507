package ms225hk_assign3.count_words;

public class Word implements Comparable<Word> {

    private String word;

    Word(String str) {
        word = str.toLowerCase();
    }

    public String toString() {
        return word;
    }

    @Override
    public int hashCode() {
        int hc = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            hc += Character.getNumericValue(c);
        }
        return hc;
    }

    public boolean equals(Object other) {
        if (other instanceof Word) {
            Word otherWord = (Word) other;
            return this.word.equalsIgnoreCase(otherWord.word);
        }
        return false;
    }

    /* Implement Comparable */
    public int compareTo(Word w) {
        return this.word.compareToIgnoreCase(w.word);
    }

}
