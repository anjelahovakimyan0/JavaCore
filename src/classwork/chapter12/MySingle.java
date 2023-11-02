package classwork.chapter12;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MySingle {

    int value();
    int xyz() default 0;
}
