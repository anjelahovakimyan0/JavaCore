package homework.util;

public class ArrayUtil {

    void print(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    void firstElement(int[] numbers) {
        System.out.println(numbers[0]);
    }

    void lastElement(int[] numbers) {
        System.out.println(numbers[numbers.length - 1]);
    }

    void arrayLength(int[] numbers) {
        System.out.println(numbers.length);
    }

    void minValue(int[] numbers) {
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println(min);
    }

    void middleValueOrValues(int[] numbers) {
        if (numbers.length <= 2) {
            System.out.println("Can't print middle value.");
        } else if (numbers.length % 2 == 0) {
            System.out.print(numbers[numbers.length / 2 - 1] + " ");
            System.out.println(numbers[numbers.length / 2]);
        } else if (numbers.length % 2 != 0) {
            System.out.println(numbers[(numbers.length - 1) / 2]);
        }
    }

    void countOfEvens(int[] numbers) {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    void countOfOdds(int[] numbers) {
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    void sum(int[] numbers) {
        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println(sum);
    }

    void average(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Average = " + sum / numbers.length);
    }
}

