package homework.fileAnalyzer;

import java.io.IOException;
import java.util.Map;

public class FileAnalyzerMain {

    private static final String FILE_PATH = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\homework\\fileAnalyzer\\file\\example.txt";

    public static void main(String[] args) {
        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        try {
            Map<String, Integer> stringIntegerMap = fileAnalyzer.wordMap(FILE_PATH);
            for (String key : stringIntegerMap.keySet()) {
                System.out.println(key + " -> " + stringIntegerMap.get(key));
            }

            System.out.println("Total count of words = " + fileAnalyzer.totalWordCount(FILE_PATH));

            System.out.println("Count of unique words = " + fileAnalyzer.uniqueWordCount(FILE_PATH));

            System.out.println("Top frequent words");
            Map<String, Integer> stringIntegerMap1 = fileAnalyzer.topFrequentWords(FILE_PATH, 3);
            for (Map.Entry<String, Integer> stringIntegerEntry : stringIntegerMap1.entrySet()) {
                System.out.println(stringIntegerEntry.getKey() + " -> " + stringIntegerEntry.getValue());
            }

            System.out.println("Count of given word = " + fileAnalyzer.countWordOccurrences(FILE_PATH, "hello"));
        } catch (IOException e) {
            System.out.println("Something went wrong. \n" + e);
        }
    }
}
