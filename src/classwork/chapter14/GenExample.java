package classwork.chapter14;

public class GenExample<T> extends NonGenExample {

    T ob;

    GenExample(T o, int i) {
        super(i);
        ob = o;
    }

    T getOb() {
        return ob;
    }
}
