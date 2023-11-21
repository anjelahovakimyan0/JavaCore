package classwork.chapter14;

public class Gen5 extends Gen<String> {

    Gen5(String o) {
        super(o);
    }

    String getOb() {
        System.out.print("Вызван метод String getOb(): ");
        return ob;
    }
}
