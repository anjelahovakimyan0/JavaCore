package classwork.chapter14;

public class NonGen {

    Object ob;

    NonGen(Object o) {
        ob = o;
    }

    public Object getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Объект ob относится к типу " + ob.getClass().getName());
    }
}
