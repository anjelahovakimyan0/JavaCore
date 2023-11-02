package classwork.chapter12;

import java.lang.reflect.Method;

public class Meta {

    @MyAnno(str = "Два параметра", val = 19)
    public static void myMeth(String str, int i) {
        Meta ob = new Meta();

        try {
            Class<? extends Meta> c = ob.getClass();
            Method m = c.getMethod("myMeth", String.class, int.class);
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exc) {
            System.out.println("Method does not found.");
        }
    }

    public static void main(String[] args) {
        myMeth("Test", 10);
    }
}
