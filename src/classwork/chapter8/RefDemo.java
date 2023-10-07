package classwork.chapter8;

public class RefDemo {

    public static void main(String[] args) {
        BoxWeight weightBox = new BoxWeight(3, 5, 7, 8.37);
        Box plainBox = new Box();
        double vol;

        vol = weightBox.volume();
        System.out.println("Объект weightBox равен " + vol);
        System.out.println("Вес weightBox равен " + weightBox.weight);

        System.out.println();

        plainBox = weightBox;

        System.out.println("Объем plainBox равен " + plainBox.volume());
    }
}
