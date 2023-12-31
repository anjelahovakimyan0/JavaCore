package classwork.chapter12;

import java.lang.reflect.Method;

public class Meta3 {

    @MyAnno()
    public static void myMeth() {
        Meta3 ob = new Meta3();
        
        try {
            Class<? extends Meta3> c = ob.getClass();
            Method m = c.getMethod("myMeth");
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exc) {
            System.out.println("Method does not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
