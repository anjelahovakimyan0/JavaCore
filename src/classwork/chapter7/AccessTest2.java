package classwork.chapter7;

public class AccessTest2 {

    public static void main(String[] args) {
        Test2 ob = new Test2();

        ob.a = 10;
        ob.b = 20;
        ob.setc(100);

        System.out.println("a, b, c: " + ob.a + " " + ob.b + " " + ob.getC());
    }
}
