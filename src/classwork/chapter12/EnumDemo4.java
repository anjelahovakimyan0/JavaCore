package classwork.chapter12;

public class EnumDemo4 {

    public static void main(String[] args) {
        Apple ap, ap2, ap3;

        System.out.println("Все константы сортов яблок и их порядковые значения:");
        for (Apple a : Apple.values()) {
            System.out.println(a + " " + a.ordinal());
        }

        ap = Apple.RED_DEL;
        ap2 = Apple.GOLDEN_DEL;
        ap3 = Apple.RED_DEL;

        System.out.println();

        if (ap.compareTo(ap2) < 0) {
            System.out.println(ap + " предшесвует " + ap2);
        }
        if (ap.compareTo(ap2) > 0) {
            System.out.println(ap2 + " предшесвует " + ap);
        }
        if (ap.compareTo(ap3) == 0) {
            System.out.println(ap + " равно " + ap3);
        }

        System.out.println();

        if (ap.equals(ap2)) {
            System.out.println("Ошибка!");
        }
        if (ap.equals(ap3)) {
            System.out.println(ap + " равно " + ap3);
        }
        if (ap == ap3) {
            System.out.println(ap + " == " + ap3);
        }
    }
}
