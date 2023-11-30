package classwork.chapter11;

public class NewThread implements Runnable {

    Thread t;

    NewThread() {
        t = new Thread(this, "Демонстрационный поток");
        System.out.println("Дочерный поток создан " + t);
        t.start();
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

    public static NewThread createAndStart() {
        NewThread nt = new NewThread();
        nt.t.start();

//        new NewThread().t.start();

        return nt;
    }
}
