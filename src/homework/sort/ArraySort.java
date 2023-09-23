package homework.sort;

public class ArraySort {

    void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[j - 1]) {
                    int temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
