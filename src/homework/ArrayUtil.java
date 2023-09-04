package homework;

public class ArrayUtil {

    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};

        //1
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();

        //2
        System.out.println(numbers[0]);

        //3
        System.out.println(numbers[numbers.length - 1]);

        //4
        System.out.println(numbers.length);

        //5
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println(min);

        //6
        if (numbers.length <= 2) {
            System.out.println("Can't print middle values.");
        } else if (numbers.length % 2 == 0) {
            System.out.print(numbers[numbers.length / 2 - 1] + " ");
            System.out.println(numbers[numbers.length / 2]);
        } else if (numbers.length % 2 != 0) {
            System.out.println(numbers[(numbers.length - 1) / 2]);
        }

        //7
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);

        //8
        count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                count++;
            }
        }
        System.out.println(count);

        //9
        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println(sum);

        //10
        sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Average = " + sum / numbers.length);
    }
}
