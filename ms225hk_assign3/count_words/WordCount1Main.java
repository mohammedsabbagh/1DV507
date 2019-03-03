package ms225hk_assign3.count_words;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static ms225hk_assign3.count_words.IdentyfyWordsMain.readText;

public class WordCount1Main {

    public static void main(String[] args) throws IOException {

        Set<Word> hashSet = new HashSet<>();
        Set<Word> treeSet = new TreeSet<>();


        String text = readText("C:\\Users\\mohasabb398\\eclipse-workspace\\1DV507\\src\\ms225hk_assign3\\count_words\\words.txt");
        String[] words = text.split(" ");

        for (String word1 : words) {
            Word word = new Word(word1);
            hashSet.add(word);
            treeSet.add(word);
        }

        for (Word word : treeSet) {
            System.out.println(word);
        }
        System.out.println("Hash-set size: " + hashSet.size());
        System.out.println("Tree-set size: " + treeSet.size());
    }
}
