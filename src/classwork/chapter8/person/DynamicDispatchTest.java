package classwork.chapter8.person;

public class DynamicDispatchTest {

    public static void main(String[] args) {
        Employee employee = new Employee("a", "a", "a", "a", "123", 13, "f");
        System.out.println(employee.hashCode());

        sendEmail(employee);

        Student student = new Student();
        sendEmail(student);
    }

    public static void sendEmail(Person person) {
        System.out.println(person.getName());
        System.out.println(person.getSurname());
        System.out.println("sending email to " + person.getEmail());
        person.printHello();
    }
}
