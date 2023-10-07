package classwork.lesson18;

public class ABTest {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.i);

        B b = new B();
        System.out.println(b.k);

        A a2 = new B();
        System.out.println(a2.j);

        a.show();
        b.show();

        System.out.println();

        a2.show();
    }
}
