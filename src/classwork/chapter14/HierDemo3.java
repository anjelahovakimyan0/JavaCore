package classwork.chapter14;

public class HierDemo3 {

    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(88);

        Gen2Example<Integer> iOb2 = new Gen2Example<>(99);

        Gen2Example<String> strOb2 = new Gen2Example<>("Тест обобщений");

        if (iOb2 instanceof Gen2Example<?>) {
            System.out.println("Объект iOb2 является экземпляром класса Gen2Example");
        }

        if (iOb2 instanceof Gen<?>) {
            System.out.println("Объект iOb2 является экземпляром класса Gen");
        }

        System.out.println();

        if (strOb2 instanceof Gen2Example<?>) {
            System.out.println("Объект strOb2 является экземпляром класса Gen2Example");
        }

        if (strOb2 instanceof Gen<?>) {
            System.out.println("Объект strOb2 является экземпляром класса Gen");
        }

        System.out.println();

        if (iOb instanceof Gen2Example<?>) {
            System.out.println("Объект iOb является экземпляром класса Gen2Example");
        }

        if (iOb instanceof Gen<?>) {
            System.out.println("Объект iOb является экземпляром класса Gen");
        }
    }
}
