package homework.util;

public class ArrayUtilTest {

    public static void main(String[] args) {
        ArrayUtil au = new ArrayUtil();
        int[] numbers = {1, 5, 6, 12, 78, 93, 4, 25, 3};

        au.print(numbers);

        System.out.println();

        au.firstElement(numbers);

        au.lastElement(numbers);

        au.arrayLength(numbers);

        au.minValue(numbers);

        au.middleValueOrValues(numbers);

        au.countOfEvens(numbers);

        au.countOfOdds(numbers);

        au.sum(numbers);

        au.average(numbers);
    }
}
