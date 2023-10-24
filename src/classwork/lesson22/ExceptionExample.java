package classwork.lesson22;

public class ExceptionExample {

    public static void main(String[] args) {
        String name = "Poxos0";
        try {
            System.out.println(StringUtil.checkString(name));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int a = 10;
        int c = 0;
        int[] numbers = {1, 2, 3};

        if (c != 0) {
            System.out.println(a / c);
        }

        int index = 2;

        if (index > 0 && index < numbers.length) {
            System.out.println(numbers[index]);
        }

        String numberStr = "121";
        try {
            int i = Integer.parseInt(numberStr);
            System.out.println(i * i);
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Hello from try");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("Hello from catch");
            System.exit(0);
        } finally {
            System.out.println("Bye from finally");
        }

        String n = "gsdgsgf";
        System.out.println(n.charAt(56));
    }
}
