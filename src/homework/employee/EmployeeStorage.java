package homework.employee;

public class EmployeeStorage {

    private Employee[] employees = new Employee[2];
    private int size;

    public void add(Employee employee) {
        if (size == employees.length) {
            extend();
        }
        employees[size++] = employee;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
        System.out.println();
    }

    public void searchByID(String employeeID) {
        for (int i = 0; i < size; i++) {
            if (employeeID.equals(employees[i].getEmployeeID())) {
                System.out.println("Name: " + employees[i].getName() + " Surname: " + employees[i].getSurname()
                        + " ID: " + employees[i].getEmployeeID() + " Salary: " + employees[i].getSalary()
                        + " Company: " + employees[i].getCompany() + " Position: " + employees[i].getPosition());
            }
        }
        System.out.println();
    }

    public void searchByCompanyName(String keyword) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().contains(keyword)) {
                System.out.println("Name: " + employees[i].getName() + " Surname: " + employees[i].getSurname()
                        + " ID: " + employees[i].getEmployeeID() + " Salary: " + employees[i].getSalary()
                        + " Company: " + employees[i].getCompany() + " Position: " + employees[i].getPosition());
            }
        }
        System.out.println();
    }

    public void deleteById(String employeeID) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(employeeID)) {
                for (int j = i + 1; j < size; j++) {
                    employees[j - 1] = employees[j];
                }
                size--;
            }
        }
    }

    public void changeEmployeeById(String employeeID, String name, String surname,
                                   double salary, String company, String position) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getEmployeeID().equals(employeeID)) {
                employees[i].setName(name);
                employees[i].setSurname(surname);
                employees[i].setSalary(salary);
                employees[i].setCompany(company);
                employees[i].setPosition(position);
            }
        }
    }

    private void extend() {
        Employee[] tmp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, tmp, 0, employees.length);
        employees = tmp;
    }
}
