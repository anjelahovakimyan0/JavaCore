package classwork.chapter8.dynamicdispatcher;

public class Dispatch {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        A r;

        r = a;
        r.callMe();

        r = b;
        r.callMe();

        r = c;
        r.callMe();

    }
}
