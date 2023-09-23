package homework.dynamicarray;

public class DynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray dy = new DynamicArray();

        dy.add(800);
        dy.add(118);
        dy.add(78);
        dy.add(68);
        dy.add(8);
        dy.add(80);
        dy.add(81);
        dy.add(82);
        dy.add(83);
        dy.add(84);
        dy.add(85);
        dy.add(86);
        dy.add(89);
        dy.add(89);
        dy.add(89);
        dy.add(89);
        dy.add(89);
        dy.add(89);
        dy.add(89);
        dy.add(1891);

        dy.print();

        System.out.println();

        dy.deleteByIndex(3);

        dy.print();

        System.out.println();

        dy.set(1, 5000);

        dy.print();

        System.out.println();

        dy.add(18, 5000);

        dy.print();

        System.out.println();

        System.out.println(dy.exists(8000));

        System.out.println(dy.getIndexByValue(89));

        System.out.println(dy.getByIndex(5));
    }
}
