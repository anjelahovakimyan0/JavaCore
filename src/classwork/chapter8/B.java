package classwork.chapter8;

public class B extends A {

    int k;

    B() {
    }

    B(int a, int b, int c) {
        super(a, b);
        k = c;
    }

    void show() {
        super.show();
        System.out.println("k: " + k);
    }

    void show(String msg) {
        System.out.println(msg + k);
    }

    void sum() {
        System.out.println("i + j + k: " + (i + j + k));
    }
}
