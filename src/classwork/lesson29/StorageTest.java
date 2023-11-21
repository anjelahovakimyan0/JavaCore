package classwork.lesson29;

public class StorageTest {

    public static void main(String[] args) {
        Storage<String> stringStorage = new Storage<>();

        stringStorage.add("Poxos");
        stringStorage.add("Petros");

        stringStorage.print();

        System.out.println("------");

        String byIndex = stringStorage.getByIndex(1);
        System.out.println(byIndex);

        System.out.println("--------------");

        Storage<Integer> intStorage = new Storage<>();

        intStorage.add(10);
        intStorage.add(20);

        intStorage.print();

        System.out.println("---");

        System.out.println(intStorage.getByIndex(1));
    }
}
