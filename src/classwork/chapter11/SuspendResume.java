package classwork.chapter11;

public class SuspendResume {

    public static void main(String[] args) {
        NewThread4 ob1 = new NewThread4("One");
        NewThread4 ob2 = new NewThread4("Two");
        
        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Suspend thread One");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Resume thread One");
            Thread.sleep(1000);
            ob2.mysuspend();
            System.out.println("Suspend thread Two");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Resume thread Two");
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}
