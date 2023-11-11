package homework.fileutil;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        fileSearch();
        contentSearch();
        findLines();
        printSizeOfPackage();
        createFileWithContent();
    }

    static void fileSearch() {
        System.out.println("Please input folder absolute path");
        String folderPath = SCANNER.nextLine();
        System.out.println("Please input wanted fileName");
        String fileName = SCANNER.nextLine();
        String filePath = folderPath + File.separator + fileName;
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    static void contentSearch() {
        System.out.println("Please input folder absolute path");
        String folderPath = SCANNER.nextLine();
        System.out.println("Please input wanted keyword");
        String keyword = SCANNER.nextLine();
        File file = new File(folderPath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File fileSearch : files) {
                    if (fileSearch.toString().endsWith(".txt")) {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new FileReader(
                                    folderPath + File.separator + fileSearch.getName()));
                            String line;
                            while ((line = bufferedReader.readLine()) != null) {
                                if (line.contains(keyword)) {
                                    System.out.println(fileSearch.getName());
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static void findLines() {
        System.out.println("Please input file path");
        String filePath = SCANNER.nextLine();
        System.out.println("Please input keyword");
        String keyword = SCANNER.nextLine();
        File file = new File(filePath);
        try {
            if (file.isFile() && file.toString().endsWith(".txt")) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.contains(keyword)) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printSizeOfPackage() {
        System.out.println("Please input folder absolute path");
        String folderPath = SCANNER.nextLine();
        File file = new File(folderPath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            long sizeOfPackage = 0;
            for (int i = 0; i < files.length; i++) {
                sizeOfPackage = files[i].length();
            }
            System.out.println(sizeOfPackage);
        }
    }

    static void createFileWithContent() {
        System.out.println("Please input folder file path");
        String folderPath = SCANNER.nextLine();
        System.out.println("Please input new fileName");
        String fileName = SCANNER.nextLine();
        System.out.println("Please input content");
        String content = SCANNER.nextLine();
        File file = new File(folderPath + File.separator + fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            if (!file.exists()) {
                file.createNewFile();
                bufferedWriter.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
