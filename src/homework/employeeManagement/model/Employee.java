package homework.employeeManagement.model;

import homework.employeeManagement.util.DateUtil;

import java.util.Date;

public class Employee {

    private String id;
    private String name;
    private String surname;
    private String phone;
    private double salary;
    private String position;
    private Company company;
    private Date dateOfBirthday;
    private Date registerDate;

    public Employee() {
    }

    public Employee(String id, String name, String surname, String phone, double salary, String position, Company company, Date dateOfBirthday, Date registerDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.salary = salary;
        this.position = position;
        this.company = company;
        this.dateOfBirthday = dateOfBirthday;
        this.registerDate = registerDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", company=" + company +
                ", dateOfBirthday=" + DateUtil.dateToString(dateOfBirthday) +
                ", registerDate=" + DateUtil.dateToString(registerDate) +
                '}';
    }
}
