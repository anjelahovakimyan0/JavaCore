package homework.fileAnalyzer;

import java.io.IOException;
import java.util.Map;

public class FileAnalyzerMain {

    private static final String FILE_PATH = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\homework\\fileAnalyzer\\file\\example.txt";

    public static void main(String[] args) {
        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        try {
            Map<String, Integer> wordMap = fileAnalyzer.wordMap(FILE_PATH);
            for (String key : wordMap.keySet()) {
                System.out.println(key + " -> " + wordMap.get(key));
            }

            System.out.println("Total count of words = " + fileAnalyzer.totalWordCount(FILE_PATH));

            System.out.println("Count of unique words = " + fileAnalyzer.uniqueWordCount(FILE_PATH));

            System.out.println("Count of given word = " + fileAnalyzer.countWordOccurrences(FILE_PATH, "hello"));
        } catch (IOException e) {
            System.out.println("Something went wrong. \n" + e);
        }
    }
}
