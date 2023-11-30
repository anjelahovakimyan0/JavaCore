package classwork.chapter11;

public class Synch {

    public static void main(String[] args) {
        CallMe1 target = new CallMe1();
        Caller1 ob1 = new Caller1(target, "Welcome");
        Caller1 ob2 = new Caller1(target, "to the synchronized");
        Caller1 ob3 = new Caller1(target, "world!");

//        CallMe target = new CallMe();
//        Caller ob1 = new Caller(target, "Welcome");
//        Caller ob2 = new Caller(target, "to the synchronized");
//        Caller ob3 = new Caller(target, "world!");
//
//

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Прервано");
        }
    }
}
