package classwork.lesson29.thread;

public class CurrentTreadExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread thread = Thread.currentThread();

        System.out.println(thread);

        thread.setName("My Thread");

        System.out.println(thread);

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println(System.currentTimeMillis());
    }
}
