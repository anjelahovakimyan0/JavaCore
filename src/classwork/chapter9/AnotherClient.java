package classwork.chapter9;

public class AnotherClient implements CallBack {

    @Override
    public void callBack(int p) {
        System.out.println("Ещё одна реализация метода callback()");
        System.out.println("p в квадрате равно " + p * p);
    }
}
