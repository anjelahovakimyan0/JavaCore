package classwork.lesson24;

public class WrapperClassExample {

    public static void main(String[] args) {
        Integer i = new Integer(12);
        Integer i2 = Integer.valueOf(12);
        Character c = new Character('#');
        Character c2 = Character.valueOf('#');
        System.out.println(i);
        System.out.println(i2);
        System.out.println(c);
        System.out.println(c2);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.max(99, 77));

        Integer a = 1050;
        Integer b = 1050;
        System.out.println(a.equals(b));

        Integer n = 10;
        Integer m = 10;
        System.out.println(n == m);
    }
}
