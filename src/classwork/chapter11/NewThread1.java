package classwork.chapter11;

public class NewThread1 extends Thread {

    NewThread1() {
        super("Демонстрационный поток");
        System.out.println("Дочерный поток: " + this);
        start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дочерный поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Дочерный поток прерван.");
        }
        System.out.println("Дочерный поток завершен.");
    }
}
