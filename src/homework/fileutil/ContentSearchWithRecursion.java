package homework.fileutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContentSearchWithRecursion {

    private static final String FOLDER_PATH = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\homework\\fileutil\\file";
    private static String keyword = "Anjela";

    static File file1 = null;
    static File file = new File(FOLDER_PATH);
    static final File FILE = new File(FOLDER_PATH);
    static String fileName;

    static void content() {
        for (int j = 0; j < FILE.listFiles().length; j++) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        file1 = files[i];
                        if (files[i].isDirectory()) {
                            if (fileName != null) {
                                fileName = fileName + file1.getName() + File.separator;
                            } else {
                                fileName = file1.getName() + File.separator;
                            }
                            file = new File(FOLDER_PATH + File.separator + fileName);
                            content();
                        } else {
                            file = new File(FOLDER_PATH + File.separator + fileName + file1);
                            if (file1.toString().endsWith(".txt")) {
                                try {
                                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
                                    String line;
                                    while ((line = bufferedReader.readLine()) != null) {
                                        if (line.contains(keyword)) {
                                            System.out.println(file1.getName());
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
        }
    }
}
