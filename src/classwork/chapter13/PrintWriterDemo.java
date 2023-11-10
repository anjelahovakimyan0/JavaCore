package classwork.chapter13;

import java.io.PrintWriter;

public class PrintWriterDemo {

    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter(System.out, true);

        printWriter.println("This line");
        int i = -7;
        printWriter.println(i);
        double d = 4.5e-7;
        printWriter.println(d);
    }
}
