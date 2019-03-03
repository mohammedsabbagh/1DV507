package ms225hk_assign3.count_words;

import java.io.IOException;

import static ms225hk_assign3.count_words.IdentyfyWordsMain.readText;

public class WordCount2Main {

    public static void main(String[] args) throws IOException {

        HashWordSet hashSet1 = new HashWordSet();
        TreeWordSet treeSet1 = new TreeWordSet();

        String text = readText("C:\\Users\\mohasabb398\\eclipse-workspace\\1DV507\\src\\ms225hk_assign3\\count_words\\words.txt");
        String[] words = text.split(" ");

        for (String word1 : words) {
            Word word = new Word(word1);
            treeSet1.add(word);
            hashSet1.add(word);

        }

        for (Word word : hashSet1) {
            System.out.println(word);
        }
        for (Word word : treeSet1) {
            System.out.println(word);
        }


        System.out.println("Hash-set size: " + hashSet1.size());
        System.out.println("Tree-set size: " + treeSet1.size());
    }
}
