package classwork.chapter14;

public class WildCardDemo {

    public static void main(String[] args) {
        Integer[] inums = {1, 2, 3, 4, 5};
        Stats<Integer> iOb = new Stats<>(inums);
        double v = iOb.average();
        System.out.println("Среднее значение iOb равно " + v);

        Double[] dnums = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dOb = new Stats<>(dnums);
        double w = dOb.average();
        System.out.println("Среднее значение dOb равно " + w);

        Float[] fnums = {1.0F, 2.0F, 3.0F, 4.0F, 5.0F};
        Stats<Float> fOb = new Stats<>(fnums);
        double x = fOb.average();
        System.out.println("Среднее значение fOb равно " + x);

        System.out.print("Средние значения iOb и dOb ");
        if (iOb.sameAvg(dOb)) {
            System.out.println("равны.");
        } else {
            System.out.println("отличаются.");
        }

        System.out.print("Средние iOb и fOb ");
        if (iOb.sameAvg(fOb)) {
            System.out.println("одинаковы.");
        } else {
            System.out.println("отличаются.");
        }
    }
}
