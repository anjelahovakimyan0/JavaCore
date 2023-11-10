package classwork.lesson27.ioExamples;

import java.io.*;

public class FileReadAndWrite {

    private static final String FILE_PATH = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\classwork\\lesson27\\ioExamples\\file\\example.txt";

    public static void main(String[] args) {
        write();
//        read();
    }

    public static void write() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (int i = 0; i < 100; i++) {
                bw.write("Hello");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
//            String line = "";
//            int lineNumber = 1;
//            while ((line = br.readLine()) != null) {
//                System.out.println(lineNumber++ + " " + line);
//            }

            int c;
            while ((c = br.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
