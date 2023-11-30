package homework.fileAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileAnalyzer {

    public Map<String, Integer> wordMap(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Map<String, Integer> resultMap = new LinkedHashMap<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.replaceAll(",", "")
                        .replaceAll(";", "")
                        .replaceAll("\\.", "")
                        .split(" ");
                for (String word : words) {
                    if (!word.trim().isEmpty()) {
                        if (resultMap.containsKey(word)) {
                            Integer count = resultMap.get(word);
                            resultMap.put(word, ++count);
                        } else {
                            resultMap.put(word, 1);
                        }
                    }
                }
            }
            return resultMap;
        }
    }

    public int totalWordCount(String path) throws IOException {
        Map<String, Integer> stringIntegerMap = wordMap(path);
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int count = 0;
            for (Integer value : stringIntegerMap.values()) {
                count += value;
            }
            return count;
        }
    }

    public int uniqueWordCount(String path) throws IOException {
        Map<String, Integer> stringIntegerMap = wordMap(path);
        int count = 0;
        for (Integer value : stringIntegerMap.values()) {
            if (value == 1) {
                count++;
            }
        }
        return count;
    }

    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        Map<String, Integer> wordMap = wordMap(path);
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordMap.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        HashMap<String, Integer> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            Map.Entry<String, Integer> stringIntegerEntry = entries.get(i);
            resultMap.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
        return resultMap;
    }

    public int countWordOccurrences(String path, String word) throws IOException {
        Map<String, Integer> stringIntegerMap = wordMap(path);
        if (!stringIntegerMap.containsKey(word)) {
            return 0;
        }
        return stringIntegerMap.get(word);
    }
}