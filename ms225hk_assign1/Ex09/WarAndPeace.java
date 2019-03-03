package ms225hk_assign1.Ex09;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class WarAndPeace {


    public static void main(String[] args) {


        String text = readText("C:\\Users\\mohasabb398\\eclipse-workspace\\1DV507\\src\\ms225hk_assign1\\Ex09\\WarAndPeace.txt");

        String[] words = text.split(" ");  // Simple split, will be cleaned up later on
        System.out.println("Initial word count: " + words.length);   // We found 577091


        Stream<String> stream = Arrays.stream(words);
        long UwordCount = stream.map(s -> s.toLowerCase().replaceAll("\\s+", "")).filter(s -> s.length() > 0).distinct().count();
        //      (\\s+) - matches sequence of one or more whitespace characters.
        //  distinct – returns a stream with unique elements.

        System.out.println("Unique word count: " + UwordCount);
    }

    public static String readText(String filename) {

        Path path = Paths.get(filename);
        try {
            return Files.readAllLines(path).stream().collect(Collectors.joining(" "));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}






