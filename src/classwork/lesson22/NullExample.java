package classwork.lesson22;

import java.util.Date;

public class NullExample {

    public static void main(String[] args) {
        String name = null;
        String name2 = "";
        System.out.println(name2.length());
        System.out.println(name);
        System.out.println(name.length());

        Date date = null;
        System.out.println(date.getTime());

        Date today = getToday(true);
        if(date != null) {
            System.out.println(today.getTime());
        }
    }

    static Date getToday(boolean a) {
        if (a) {
            return new Date();
        }
        return null;
    }
}
