package homework.fileAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileAnalyzer {

    public Map<String, Integer> wordMap(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Map<String, Integer> wordMap = new LinkedHashMap<>();
            List<String> arrayList = new ArrayList<>();
            String line, word;
            int count;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                arrayList.addAll(List.of(words));
            }
            for (int i = 0; i < arrayList.size(); i++) {
                count = 0;
                word = arrayList.get(i);
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j).equals(word)) {
                        wordMap.put(word, ++count);
                    }
                }
            }
            return wordMap;
        }
    }

    public int totalWordCount(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                for (int i = 0; i < words.length; i++) {
                    count++;
                }
            }
            return count;
        }
    }

    public int uniqueWordCount(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Set<String> wordSet = new HashSet<>();
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                for (String word : words) {
                    if (wordSet.add(word)) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        Map<String, Integer> stringIntegerMap = wordMap(path);
        List<Map.Entry<String, Integer>> list = new LinkedList<>(stringIntegerMap.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        stringIntegerMap.clear();
        for (int i = 0; i < n; i++) {
            stringIntegerMap.put(list.get(i).getKey(), list.get(i).getValue());
        }
        return stringIntegerMap;
    }

    public int countWordOccurrences(String path, String word) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].contains(word)) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}