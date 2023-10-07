package classwork.lesson8;

public class NumbersArrayExample {

    public static void main(String[] args) {
        int[] numbers = {33, 22, 11, 56, 89, 23, 55};
        char[] chars = {'%', '^', '&', '*', '(', ')', '+'};
        System.out.println(numbers[0]);
        int lastIndex = numbers.length - 1;
        System.out.println(numbers[lastIndex]);

        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " " + chars[i] + " ");
        }
    }

}
