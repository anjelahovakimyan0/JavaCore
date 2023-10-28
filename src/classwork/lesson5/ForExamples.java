package classwork.lesson5;

public class ForExamples {

    public static void main(String[] args) {
        int count = 1000;
        for (int i = 1; i <= count; i++) {
            System.out.print(i);
            if (i != count) {
                System.out.print("-");
            }
        }

        System.out.println();

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        int[] array = {2, 5, 8, 4, 9, 3, 7};
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
    }
}
