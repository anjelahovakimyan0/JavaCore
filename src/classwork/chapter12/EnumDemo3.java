package classwork.chapter12;

public class EnumDemo3 {

    public static void main(String[] args) {
        System.out.println("Яблоко сорта winesap стоит " + Apple.WINESAP.getPrice() + " центов.\n");

        System.out.println("Цены на все сорта яблок:");
        for (Apple apple : Apple.values()) {
            System.out.print(apple + " стоит " + apple.getPrice() + " центов.\n");
        }
    }
}
