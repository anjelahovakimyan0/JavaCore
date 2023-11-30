package classwork.chapter11;

public class Caller1 implements Runnable {

    String msg;
    CallMe1 target;
    Thread t;

    Caller1(CallMe1 targ, String s) {
        msg = s;
        target = targ;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}
