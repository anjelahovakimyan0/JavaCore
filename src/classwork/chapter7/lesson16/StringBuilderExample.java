package classwork.chapter7.lesson16;

public class StringBuilderExample {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder("Hello");
        for (int i = 0; i < 10; i++) {
            result.append(i);
        }
        System.out.println(result);
    }
}
