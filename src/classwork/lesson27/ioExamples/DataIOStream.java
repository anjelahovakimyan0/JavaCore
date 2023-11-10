package classwork.lesson27.ioExamples;

import java.io.*;

public class DataIOStream {

    private static final String FILE_PATH = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\classwork\\lesson27\\file\\example.txt";

    public static void main(String[] args) throws IOException {
//        write();
        read();
    }

    public static void write() throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE_PATH));
        out.writeInt(33);
        out.writeUTF("Hello from Java!");
        out.close();
    }

    public static void read() throws IOException {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(FILE_PATH));
        System.out.println(inputStream.readInt());
        System.out.println(inputStream.readUTF());
        inputStream.close();
    }
}
