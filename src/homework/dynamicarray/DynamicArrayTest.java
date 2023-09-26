package homework.dynamicarray;

public class DynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray dy = new DynamicArray();

        dy.add(800);
        dy.add(118);
        dy.add(78);

        dy.print();

        dy.set(1, 5000);

        dy.print();

        dy.add(1, 500000);

        dy.print();

        System.out.println(dy.exists(8000));

        System.out.println(dy.getIndexByValue(89));

        System.out.println(dy.getByIndex(1));

        dy.print();

        dy.deleteByIndex(1);

        dy.print();
    }
}
