package homework.employeeManagement;

import java.util.Scanner;

public class EmployeeManagementMain {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();
    private static CompanyStorage companyStorage = new CompanyStorage();

    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            printCommands();

            String command = scanner.nextLine();

            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addCompany();
                    break;
                case "2":
                    addEmployee();
                    break;
                case "3":
                    companyStorage.print();
                    break;
                case "4":
                    employeeStorage.print();
                    break;
                case "5":
                    searchEmployeeById();
                    break;
                case "6":
                    searchEmployeeByCompany();
                    break;
                case "7":
                    deleteCompany();
                    break;
                case "8":
                    deleteEmployee();
                    break;
                case "9":
                    changeCompany();
                    break;
                case "10":
                    changeEmployee();
                    break;
                default:
                    System.out.println("Invalid command. Please try again!");
            }
        }
    }

    private static void changeEmployee() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null) {
            System.out.println("Company with " + companyId + " dose not exists!!!");
            return;
        }
        employeeStorage.searchEmployeesByCompany(companyFromStorage);

        System.out.println("Please input employee id");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if (employeeFromStorage == null) {
            System.out.println("Employee does not exists");
            return;
        }

        System.out.println("Please input employee name");
        String name = scanner.nextLine();

        System.out.println("Please input employee surname");
        String surname = scanner.nextLine();

        System.out.println("Please input employee phone");
        String phone = scanner.nextLine();

        System.out.println("Please input employee salary");
        double salary = Double.parseDouble(scanner.nextLine());

        System.out.println("Please input employee position");
        String position = scanner.nextLine();

        employeeFromStorage.setName(name);
        employeeFromStorage.setSurname(surname);
        employeeFromStorage.setPhone(phone);
        employeeFromStorage.setSalary(salary);
        employeeFromStorage.setPosition(position);
        System.out.println("Employee updated.");
    }

    private static void changeCompany() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null) {
            System.out.println("Company with " + companyId + " does not exists!!!");
            return;
        }

        System.out.println("Please input new company name");
        String companyName = scanner.nextLine();

        System.out.println("Please input new company address");
        String companyAddress = scanner.nextLine();

        companyFromStorage.setName(companyName);
        companyFromStorage.setAddress(companyAddress);
        System.out.println("Company updated.");
    }

    private static void deleteEmployee() {
        System.out.println("Please input company id");
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null) {
            System.out.println("Company with " + companyId + " id does not exists!!!");
            return;
        }
        employeeStorage.searchEmployeesByCompany(companyFromStorage);

        System.out.println("Please input employee id");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if (employeeFromStorage == null) {
            System.out.println("Employee with does not exists");
            return;
        }

        if(!employeeFromStorage.getCompany().equals(companyFromStorage)) {
            System.out.println("Wrong employee id");
            return;
        }
        employeeStorage.deleteById(employeeId);
        System.out.println("Employee deleted.");
    }

    private static void addCompany() {
        System.out.println("Please input company id");
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage != null) {
            System.out.println("Company with " + companyId + " already exists!!!");
            return;
        }

        System.out.println("Please input company name");
        String companyName = scanner.nextLine();

        System.out.println("Please input company address");
        String companyAddress = scanner.nextLine();

        Company company = new Company(companyId, companyName, companyAddress);
        companyStorage.add(company);
        System.out.println("Company registered.");
    }

    private static void deleteCompany() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null) {
            System.out.println("Company with " + companyId + " does not exists!!!");
            return;
        }

        companyStorage.deleteById(companyId);
    }

    private static void searchEmployeeByCompany() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null) {
            System.out.println("Company with " + companyId + " does not exists!!!");
            return;
        }

        employeeStorage.searchEmployeesByCompany(companyFromStorage);
    }

    private static void searchEmployeeById() {
        System.out.println("Please input employee Id");
        String employeeId = scanner.nextLine();
        Employee byId = employeeStorage.getById(employeeId);
        if(byId == null) {
            System.out.println("Employee with " + employeeId + " does not exists!!!");
            return;
        }
        System.out.println(byId);
    }

    private static void addEmployee() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null) {
            System.out.println("Company with " + companyId + " dose not exists!!!");
            return;
        }

        System.out.println("Please input employee id");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if (employeeFromStorage != null) {
            System.out.println("Employee with " + employeeId + " id already exists");
            return;
        }

        System.out.println("Please input employee name");
        String name = scanner.nextLine();

        System.out.println("Please input employee surname");
        String surname = scanner.nextLine();

        System.out.println("Please input employee phone");
        String phone = scanner.nextLine();

        System.out.println("Please input employee salary");
        double salary = Double.parseDouble(scanner.nextLine());

        System.out.println("Please input employee position");
        String position = scanner.nextLine();

        Employee employee = new Employee(employeeId, name, surname, phone, salary, position, companyFromStorage);
        employeeStorage.add(employee);
        System.out.println("Employee registered.");
    }

    private static void printCommands() {
        System.out.println("Please input 0 for EXIT");
        System.out.println("Please input 1 for ADD_COMPANY");
        System.out.println("Please input 2 for ADD_EMPLOYEE");
        System.out.println("Please input 3 for PRINT_ALL_COMPANIES");
        System.out.println("Please input 4 for PRINT_ALL_EMPLOYEES");
        System.out.println("Please input 5 for SEARCH_EMPLOYEE_BY_ID");
        System.out.println("Please input 6 for SEARCH EMPLOYEE_BY_COMPANY");
        System.out.println("Please input 7 for DELETE_COMPANY");
        System.out.println("Please input 8 for DELETE_EMPLOYEE");
        System.out.println("Please input 9 for CHANGE_COMPANY");
        System.out.println("Please input 10 for CHANGE_EMPLOYEE");
    }
}
