package classwork.chapter8;

public class SimpleInheritance {

    public static void main(String[] args) {
        A superOb = new A();
        B subOb = new B();

        superOb.i = 10;
        superOb.j = 20;

        System.out.println("Содержимое объекта superOb: ");
        superOb.show();

        System.out.println();

        subOb.i = 7;
        subOb.j = 8;
        subOb.k = 9;

        subOb.show();
        subOb.show();

        System.out.println();

        System.out.println("Сумма i, j, k в объекте subOb: ");
        subOb.sum();
    }
}
