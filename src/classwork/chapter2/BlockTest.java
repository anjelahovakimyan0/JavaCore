package classwork.chapter2;

/*
* Продемонстрировать применение блока кода.
*
* Просвоить исходному файлу имя "BookTest.java"
* */
public class BlockTest {

    public static void main(String[] args) {
        int x, y;

        y = 30;

        for (x = 0; x < 10; x++) {
            System.out.println("Значение x:" + x);
            System.out.println("Значение y:" + y);
            y = y - 2;
        }
    }
}
