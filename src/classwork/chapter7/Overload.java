package classwork.chapter7;

public class Overload {

    public static void main(String[] args) {
        OverloadDemo ob = new OverloadDemo();
        int i = 88;
        double result;

        ob.test();
        ob.test(10, 20);
        ob.test(i);
        result = ob.test(123.25);
        System.out.println("Резудьтат вызова ob.test(123.25): " + result);
    }
}
