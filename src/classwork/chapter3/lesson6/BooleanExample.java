package classwork.chapter3.lesson6;

public class BooleanExample {

    public static void main(String[] args) {
        int a = 10;
        int b = 50;
        boolean c = a > b;
        System.out.println(c);

        if(!c) {  // !c -> c == false
            System.out.println("a less than b");
        }
    }

}
