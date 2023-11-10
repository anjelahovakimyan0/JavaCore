package classwork.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinyEdit {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[100];
        System.out.println("Please input text lines");
        System.out.println("Please input 'stop' for exit");
        for (int i = 0; i < 100; i++) {
            str[i] = bufferedReader.readLine();
            if (str[i].equals("stop")) {
                break;
            }
        }
        System.out.println("\nСодержимое вашего файла:");
        for (int i = 0; i < 100; i++) {
            if (str[i].equals("stop")) {
                break;
            }
            System.out.println(str[i]);
        }
    }
}
