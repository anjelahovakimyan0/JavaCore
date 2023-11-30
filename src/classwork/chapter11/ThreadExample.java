package classwork.chapter11;

public class ThreadExample {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 6; i++) {
                        System.out.println("newThread " + i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Main " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
