package classwork.chapter10.lesson22;

public class ExceptionExample {

    public static void main(String[] args) {
        int a = 10;
        int c = 0;
        int[] numbers = {1, 2, 3};

        if(c != 0) {
            System.out.println(a / c);
        }

        int index = 2;
        if(index > 0 && index < numbers.length) {
            System.out.println(numbers[index]);
        }
    }
}
