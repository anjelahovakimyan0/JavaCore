package classwork.chapter9;

public class TestIFace {

    public static void main(String[] args) {
        CallBack c = new Client();
        c.callBack(42);
    }
}
