package homework.fileutil;

import java.io.*;

public class FileUtil {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static void fileSearch(String path, String fileName) {
        File filePath = new File(path);
        if (filePath.isDirectory()) {
            File[] files = filePath.listFiles();
            for (File file : files) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    System.out.println(true);
                } else if (file.isDirectory()) {
                    fileSearch(file.getAbsolutePath(), fileName);
                }
            }
        }
    }

    static void contentSearch(String path, String keyword) {
        File directory = new File(path);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile() && file.toString().endsWith(".txt")) {
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                        String line;
                        int lineNumber = 1;
                        while ((line = bufferedReader.readLine()) != null) {
                            if (line.contains(keyword)) {
                                System.out.println(ANSI_GREEN + file.getName()
                                        + ANSI_YELLOW + " line number: " + lineNumber
                                        + ANSI_PURPLE + " line: " + line + ANSI_RESET);
                                break;
                            }
                            lineNumber++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    contentSearch(file.getAbsolutePath(), keyword);
                }
            }
        }
    }

    static void findLines(String path, String keyword) {
        File directory = new File(path);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile() && file.toString().endsWith(".txt")) {
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            if (line.contains(keyword)) {
                                System.out.println(line);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    findLines(file.getAbsolutePath(), keyword);
                }
            }
        }
    }

    static long printSizeOfPackage(String path) {
        long sizeOfPackage = 0;
        File filePath = new File(path);
        if (filePath.isDirectory()) {
            File[] files = filePath.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        for (File fileWithSize : files) {
                            sizeOfPackage += fileWithSize.length();
                        }
                    } else if (file.isDirectory()) {
                        printSizeOfPackage(file.getAbsolutePath());
                    }
                }
            }
        }
        return sizeOfPackage;
    }

    static void createFileWithContent(String path, String fileName, String content) {
        File file = new File(path, fileName);
        if (!file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                file.createNewFile();
                bw.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
