package classwork.lesson20;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateExample {

    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {
        System.out.println("Please input birthday(dd/MM/yyyy)");
        String birthdayStr = scanner.nextLine();
        Date date = sdf.parse(birthdayStr);
        System.out.println(date);
    }
}
