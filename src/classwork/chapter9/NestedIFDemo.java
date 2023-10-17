package classwork.chapter9;

public class NestedIFDemo {

    public static void main(String[] args) {
        A.NestedIF nif = new B();

        if(nif.isNotNegative(10)) {
            System.out.println("Число 10 неотрицательное");
        }
        if(nif.isNotNegative(-12)) {
            System.out.println("Это не будет выведено");
        }
    }
}
