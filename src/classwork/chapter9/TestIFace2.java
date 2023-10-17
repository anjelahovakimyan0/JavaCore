package classwork.chapter9;

public class TestIFace2 {

    public static void main(String[] args) {
        CallBack c = new Client();
        AnotherClient ob = new AnotherClient();

        c.callBack(42);

        c = ob;

        c.callBack(42);
    }
}
