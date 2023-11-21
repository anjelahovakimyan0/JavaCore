package classwork.chapter5;

public class ForEach3 {

    public static void main(String[] args) {
        int sum = 0;
        int[][] nums = new int[3][5];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                nums[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int[] x : nums) {
            for (int y : x) {
                System.out.println("Значение равно: " + y);
                sum += y;
            }
        }
        System.out.println("Сумма в for each: " + sum);

        System.out.println();

        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.println("element = " + nums[i][j]);
                sum += nums[i][j];
            }
        }
        System.out.println("Сумма в for: " + sum);
    }
}
