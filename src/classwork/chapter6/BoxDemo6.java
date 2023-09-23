package classwork.chapter6;

public class BoxDemo6 {

    public static void main(String[] args) {
        Box myBox1 = new Box(10, 10, 10);
        Box myBox2 = new Box(10, 10, 10);
        double vol;

        vol = myBox1.volume();
        System.out.println("Объем равен " + vol);

        vol = myBox2.volume();
        System.out.println("Объем равен " + vol);
    }
}
