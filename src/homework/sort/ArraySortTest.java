package homework.sort;

public class ArraySortTest {

    public static void main(String[] args) {
        ArraySort as = new ArraySort();
        int[] numbers = {6, 4, 8, 2, 9, 10, 3, 7};

        as.sort(numbers);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
