package classwork.chapter14;

public class Gen3<T> {

    T ob;

    Gen3(T o) {
        ob = o;
    }

    T getOb() {
        System.out.print("Метод getOb из класса Gen3: ");
        return ob;
    }
}
