package classwork.lesson21;

public class ArmPerson implements SayHello, SayGoodbye {

    @Override
    public String sayGoodbye() {
        return "Ցտեսություն";
    }

    @Override
    public String sayHello() {
        return "Բարև";
    }
}
