package classwork.chapter2;

/*
 * Это ещё один пример короткой программы
 * Присвоить исходному файлу имя "Example2.java"
 * */
public class Example2 {

    public static void main(String[] args) {
        int num; // В этой строке кода объявляется
        // переменная с именем num
        num = 100; // В этой строке кода переменной num
        // присваивается значение 100
        System.out.println("Это переменная num: " + num);

        num = num * 2;

        System.out.print("Значение переменной num * 2 равно ");
        System.out.println(num);

        System.out.println("num is: " + num);

        num = 200;
        System.out.println("now num is: " + num);

        int age = 10;
        System.out.println("sum: " + (age + num));
    }

}
