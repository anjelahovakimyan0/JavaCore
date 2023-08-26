package classwork.chapter2.lesson5;

public class ForSample {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println((i + 1) + " poxos");
        }

        System.out.println();
        
        for (int i = 0; i < 100; i++) {
            System.out.println("poxos");
            if(i == 50) {
                System.out.println("petros");
            }
        }

        System.out.println();

        int i;

        for (i = 0; i < 100; i++) {
            System.out.println("poxos");
        }

        System.out.println(i);
        System.out.println("petros");
    }

}
