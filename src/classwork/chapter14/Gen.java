package classwork.chapter14;

public class Gen<T> {

    T ob;

    public Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Типом T является " + ob.getClass().getName());
    }
}
