package classwork.chapter9;

public class MyIFImp2 implements MyIF {

    @Override
    public int getNumber() {
        return 100;
    }

    @Override
    public String getString() {
        return "Это другая символьная строка.";
    }
}
