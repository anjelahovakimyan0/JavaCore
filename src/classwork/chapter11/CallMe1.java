package classwork.chapter11;

public class CallMe1 {

    public void call(String msg) {
        try {
            System.out.print("[" + msg);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прерван");
        }
        System.out.println("]");
    }
}
