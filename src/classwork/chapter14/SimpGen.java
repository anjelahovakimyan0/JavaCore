package classwork.chapter14;

public class SimpGen {

    public static void main(String[] args) {
        TwoGen<Integer, String> tgObj = new TwoGen<>(88, "Обобщения");

        tgObj.showTypes();

        System.out.println();

        int v = tgObj.getOb1();
        System.out.println("Значение: " + v);

        System.out.println();

        String str = tgObj.getOb2();
        System.out.println("Значение: " + str);
    }
}
