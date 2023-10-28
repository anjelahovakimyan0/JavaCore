package classwork.chapter12;

public class EnumDemo2 {
    public static void main(String[] args) {
        Apple ap;

        System.out.println("Константы перечислимого типа Apple:");

        Apple[] values = Apple.values();
        for (Apple value : values) {
            System.out.println(value);
        }
        System.out.println();

        ap = Apple.valueOf("WINESAP");
        System.out.println("Переменная ap содержит " + ap);
    }
}
