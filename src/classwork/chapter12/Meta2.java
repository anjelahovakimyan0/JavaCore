package classwork.chapter12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@MyAnno(str = "Meta2", val = 99)
public class Meta2 {

    @MyAnno(str = "Testing", val = 100)
    public static void myMeth() {
        Meta2 ob = new Meta2();

        try {
            Annotation[] annos = ob.getClass().getAnnotations();
            System.out.println("Все аннотации для класса Meta2:");
            for (Annotation a : annos) {
                System.out.println(a);
            }
            System.out.println();
            Method m = ob.getClass().getMethod("myMeth");
            annos = m.getAnnotations();
            System.out.println("Все аннотации для метода myMeth():");
            for (Annotation a : annos) {
                System.out.println(a);
            }
        } catch (NoSuchMethodException exc) {
            System.out.println("Method does not found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
