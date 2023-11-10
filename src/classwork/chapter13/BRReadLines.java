package classwork.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRReadLines {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Please input text lines");
        System.out.println("Please input 'stop' for exit");
        do {
            str = bufferedReader.readLine();
            System.out.println(str);
        } while (!str.equals("stop"));
    }
}
