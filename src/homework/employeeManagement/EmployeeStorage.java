package homework.employeeManagement;

public class EmployeeStorage {

    private Employee[] employees = new Employee[10];
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

    public void deleteById(String employeeId) {
        int indexById = getIndexById(employeeId);
        if(indexById == -1) {
            System.out.println("Employee does not exists!!!");
            return;
        }
        for (int i = indexById + 1; i < size; i++) {
            employees[i - 1] = employees[i];
        }
        size--;
    }

    public void changeEmployeeById(String employeeID, String name, String surname,
                                   double salary, Company company, String position) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getId().equals(employeeID)) {
                employees[i].setName(name);
                employees[i].setSurname(surname);
                employees[i].setSalary(salary);
                employees[i].setCompany(company);
                employees[i].setPosition(position);
            }
        }
    }

    public Employee getById(String employeeID) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getId().equals(employeeID)) {
                return employees[i];
            }
        }
        return null;
    }

    public void searchEmployeesByCompany(Company companyFromStorage) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getCompany().equals(companyFromStorage)) {
                System.out.println(employees[i]);
            }
        }
    }

    private int getIndexById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getId().equals(employeeId)) {
                return i;
            }
        }
        return -1;
    }

    private void extend() {
        Employee[] tmp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, tmp, 0, employees.length);
        employees = tmp;
    }
}
