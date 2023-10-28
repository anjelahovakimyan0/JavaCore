package classwork.chapter12;

public class AutoBox6 {

    public static void main(String[] args) {
        Boolean b = true;

        if(b) {
            System.out.println("b is true");
        }

        Character ch = 'x';
        char ch2 = ch;

        System.out.println("ch2 равно " + ch2);
    }
}
