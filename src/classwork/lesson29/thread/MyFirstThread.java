package classwork.lesson29.thread;

public class MyFirstThread implements Runnable {

    MyFirstThread() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(thread.getName() + " " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
