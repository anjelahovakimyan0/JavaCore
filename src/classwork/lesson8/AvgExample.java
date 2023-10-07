package classwork.lesson8;

public class AvgExample {

    public static void main(String[] args) {
        double[] numbers = {10.1, 11.2, 12.3, 13.4, 14.5};
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        System.out.println("sum: " + sum);
        System.out.println("avg: " + sum / numbers.length);
    }

}
