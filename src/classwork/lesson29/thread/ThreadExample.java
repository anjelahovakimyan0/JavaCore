package classwork.lesson29.thread;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        new MyFirstThread();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main " + i);
            Thread.sleep(1000);
        }
    }
}
