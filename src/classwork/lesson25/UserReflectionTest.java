package classwork.lesson25;

import classwork.lesson24.User;
import classwork.lesson25.annotation.FirstAnnotation;
import classwork.lesson25.annotation.Model;
import homework.onlineStore.model.enums.Language;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class UserReflectionTest {

    public static void main(String[] args) {
        User user = new User("Poxos", "Poxosyan", "poxos@gmail.com", Language.HY);

        Class<? extends User> uClass = user.getClass();

        Method[] declaredMethods = uClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.isAnnotationPresent(FirstAnnotation.class)) {
                System.out.println(declaredMethod);
            }
        }

        System.out.println();

        Method[] declaredMethods1 = User.class.getDeclaredMethods();

        for (Method declaredMethod1 : declaredMethods1) {
            Annotation[] declaredAnnotations = declaredMethod1.getDeclaredAnnotations();
            if(declaredAnnotations.length > 0) {
                System.out.print(declaredMethod1.getName() + " -> ");
                for (Annotation declaredAnnotation : declaredAnnotations) {
                    System.out.println(declaredAnnotation.annotationType());
                }
            }
        }

        System.out.println();

        Model annotation = User.class.getAnnotation(Model.class);
        if(annotation != null) {
            System.out.println(annotation.val());
        }

        System.out.println();

        try {
            Method printHello = User.class.getMethod("printHello1");
            System.out.println(printHello);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
