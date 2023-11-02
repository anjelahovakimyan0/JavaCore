package classwork.chapter12;

import java.lang.reflect.Method;

public class Single {

    @MySingle(100)
    public static void myMeth() {
        Single ob = new Single();

        try {
            Method m = ob.getClass().getMethod("myMeth");
            MySingle anno = m.getAnnotation(MySingle.class);
            System.out.println(anno.value());
        } catch (NoSuchMethodException exc) {
            System.out.println("Method does not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
