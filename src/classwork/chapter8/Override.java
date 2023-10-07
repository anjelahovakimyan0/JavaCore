package classwork.chapter8;

public class Override {

    public static void main(String[] args) {
        B subOb = new B(1, 2, 3);
        subOb.show();

        System.out.println();

        subOb.show("Это k: ");
    }
}
