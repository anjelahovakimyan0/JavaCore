package classwork.chapter7;

public class OverloadDemo {

    void test() {
        System.out.println("Параметры отсутствуют.");
    }

    void test(int a, int b) {
        System.out.println("a и  b: " + a + " " + b);
    }

    double test(double a) {
        System.out.println("a: " + a);
        return a * a;
    }
}
