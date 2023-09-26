package classwork.chapter7.lesson15;

public class FinalDemo {

    final int b;

    FinalDemo(int b) {
        this.b = b;
    }

    FinalDemo(int a, int b) {
        this.b = b;
    }

    FinalDemo(String name) {
        b = 20;
    }

    public static void main(String[] args) {
        final int a;
        a = 10;
    }
}
