package classwork.chapter10;

public class SuperSubCatch {

    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 42 / a;
        } catch (ArithmeticException e) {
            System.out.println("/ by zero");
        } catch (Exception e) {
            System.out.println("Переxват исключений общего класса Exception.");
        }
    }
}
