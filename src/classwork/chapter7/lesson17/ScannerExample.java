package classwork.chapter7.lesson17;

import classwork.chapter7.lesson15.ArrayUtil;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input numbers divided by ,");
        String numbersStr = scanner.nextLine();
        String[] numbersStrArray = numbersStr.split(",");
        int[] numbers = new int[numbersStrArray.length];
        int index = 0;
        for (String numberStr : numbersStrArray) {
            numbers[index++] = Integer.parseInt(numberStr);
        }
        int max = ArrayUtil.max(numbers);
        System.out.println("Max: " + max);

        System.out.println();

        System.out.println("Please input a");
        int a = Integer.parseInt(scanner.nextLine());

        System.out.println("Please input b");
        int b = Integer.parseInt(scanner.nextLine());

        System.out.println("Please input + or -");
        String op = scanner.nextLine();

        if(op.equals("+")) {
            System.out.println(a + b);
        } else if (op.equals("-")) {
            System.out.println(a - b);
        } else {
            System.out.println("Unsupported");
        }

        System.out.println("Please input full name");
        String fullName = scanner.nextLine();
        String[] fullNameArray = fullName.split(" ");

        System.out.println(fullNameArray[0]);
        System.out.println(fullNameArray[1]);
    }
}
