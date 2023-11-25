package classwork.lesson29.compare;

import java.util.Date;

public class Student implements Comparable<Student> {

    private String name;
    private String surname;
    private int age;
    private Date registerDate;

    public Student(String name, String surname, int age, Date registerDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.registerDate = registerDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", registerDate=" + registerDate +
                '}';
    }

    @Override
    public int compareTo(Student o) {
//        if (age > o.age) {
//            return 1;
//        } else if (age < o.age) {
//            return -1;
//        }
//        return 0;

        return name.compareTo(o.getName());
    }
}
