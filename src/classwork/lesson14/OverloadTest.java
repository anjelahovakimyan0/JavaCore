package classwork.lesson14;

public class OverloadTest {

    public static void main(String[] args) {
        String fullName = "Poxos Poxosyan";

        String name = fullName.substring(0, 5);
        String surname = fullName.substring(6);

        System.out.println(name);
        System.out.println(surname);
    }
}
