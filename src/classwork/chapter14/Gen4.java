package classwork.chapter14;

public class Gen4<T> extends Gen3<T> {

    Gen4(T o) {
        super(o);
    }

    T getOb() {
        System.out.print("Метод getOb из класса Gen4: ");
        return ob;
    }
}
