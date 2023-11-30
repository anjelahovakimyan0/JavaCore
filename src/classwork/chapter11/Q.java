package classwork.chapter11;

public class Q {

    int n;
    boolean valueSet = false;

    synchronized int get() {
        try {
            while (!valueSet) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Исключение типа InterruptedException перехвачено");
        }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        try {
            while (valueSet) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Исключение типа InterruptedException перехвачено");
        }
        this.n = n;
        valueSet = true;
        System.out.println("Sent: " + n);
        notify();
    }
}
