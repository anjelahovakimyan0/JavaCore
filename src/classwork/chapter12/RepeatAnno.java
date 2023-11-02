package classwork.chapter12;

import java.lang.reflect.Method;

public class RepeatAnno {

    @MyAnno(str = "First annotation", val = -1)
    @MyAnno(str = "Second annotation", val = 100)
    public static void myMeth(String str, int i) {
        RepeatAnno ob = new RepeatAnno();

        try {
            Class<? extends RepeatAnno> c = ob.getClass();
            Method m = c.getMethod("myMeth", String.class, int.class);
            MyRepeatedAnnos anno = m.getAnnotation(MyRepeatedAnnos.class);
            System.out.println(anno);

            System.out.println();

            MyAnno[] annos = m.getAnnotationsByType(MyAnno.class);
            for (MyAnno myAnno : annos) {
                System.out.println(myAnno);
            }
        } catch (NoSuchMethodException exc) {
            System.out.println("Method does not found");
        }
    }

    public static void main(String[] args) {
        myMeth("test", 10);
    }
}
