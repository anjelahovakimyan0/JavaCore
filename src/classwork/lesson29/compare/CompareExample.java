package classwork.lesson29.compare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CompareExample {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) throws ParseException {
        Set<String> nameSet = new TreeSet<>();

        nameSet.add("Zaven");
        nameSet.add("Aram");
        nameSet.add("Poxos");

        for (String s : nameSet) {
            System.out.println(s);
        }

        System.out.println();

        Set<Student> students = new TreeSet<>(new DateComparator().reversed());

        students.add(new Student("poxos", "poxosyan", 23, simpleDateFormat.parse("21-06-2023")));
        students.add(new Student("petros", "petrosyan", 60,  simpleDateFormat.parse("25-05-2023")));
        students.add(new Student("martiros", "martirosyan", 33,  simpleDateFormat.parse("24-01-2023")));

        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("------");

        for (Student student : students) {
            System.out.println(student);
        }

        Student student = new Student("poxos", "poxosyan", 23, simpleDateFormat.parse("21-01-2023"));
        Student student2 = new Student("petros", "petrosyan", 60,  simpleDateFormat.parse("25-05-2023"));
        System.out.println(student.compareTo(student2));

        System.out.println();

        List<Student> students2 = new ArrayList<>();
        students2.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
//      Comparator.comparing(Student::getSurname));

//      (o1, o2) -> o1.getSurname().compareTo(o2.getSurname())
    }
}
