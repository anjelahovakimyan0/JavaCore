package classwork.chapter9.lesson21;

public class InterfaceTest {

    public static void main(String[] args) {
        ArmPerson armPerson = new ArmPerson();
        printHello(armPerson);
        EnglishPerson englishPerson = new EnglishPerson();
        printHello(englishPerson);

        System.out.println();

        System.out.println(MyInterface.a);
    }

    static void printHello(SayHello sayHello) {
        System.out.println(sayHello.sayHello());
        if(sayHello instanceof SayGoodbye) {
            SayGoodbye sayGoodbye = (SayGoodbye) sayHello;
            System.out.println(sayGoodbye.sayGoodbye());
        }
    }
}
