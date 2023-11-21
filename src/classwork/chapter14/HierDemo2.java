package classwork.chapter14;

public class HierDemo2 {

    public static void main(String[] args) {
        GenExample<String> w = new GenExample<>("Добро пожаловать", 47);

        System.out.print(w.getOb() + " ");
        System.out.println(w.getNum());
    }
}
