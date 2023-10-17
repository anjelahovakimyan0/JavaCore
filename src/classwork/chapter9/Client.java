package classwork.chapter9;

public class Client implements CallBack {

    @Override
    public void callBack(int p) {
        System.out.println("Метод callback(), вызываемый со значением " + p);
    }

    void nonIfMeth() {
        System.out.println("В классах, реализующих интерфейсы, могут определяться и другие члены.");
    }
}
