package ms225hk_assign3.count_words;


import java.io.*;


public class IdentyfyWordsMain {

    protected static String readText(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        FileReader text = new FileReader(filePath);
        BufferedReader br = new BufferedReader(text);
        while ((line = br.readLine()) != null) {
            String cleanLine = line.replaceAll("[^A-Za-z ]", "");
            sb.append(cleanLine).append("\n");
        }
        br.close();
        return sb.toString();
    }

    private static void saveFile(String filePath, String text) throws IOException {
        File file = new File(filePath);
        PrintWriter printer = new PrintWriter(file);
        printer.print(text);
        printer.close();
    }

    public static void main(String[] args) throws IOException {
        try {
            String text = readText("C:\\Users\\mohasabb398\\eclipse-workspace\\1DV507\\src\\ms225hk_assign3\\count_words\\HistoryOfProgramming.txt");
            saveFile("C:\\Users\\mohasabb398\\eclipse-workspace\\1DV507\\src\\ms225hk_assign3\\count_words\\words.txt", text);
            System.out.println("File has been saved to words.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
