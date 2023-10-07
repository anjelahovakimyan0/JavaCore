package homework.employee;

import java.util.Scanner;

public class EmployeeDemo {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();

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
                    addEmployee(scanner, employeeStorage);
                    break;
                case "2":
                    employeeStorage.print();
                    break;
                case "3":
                    searchByID(scanner, employeeStorage);
                    break;
                case "4":
                    searchByCompanyName(scanner, employeeStorage);
                    break;
                case "5":
                    deleteByID(scanner, employeeStorage);
                    break;
                case "6":
                    changeByID(scanner, employeeStorage);
                    break;
                default:
                    System.out.println("Invalid command. Please try again!");
            }
        }
    }

    private static void changeByID(Scanner scanner, EmployeeStorage employeeStorage) {
        System.out.println("Please input employee ID");
        String employeeID = scanner.nextLine();

        System.out.println("Please input employee name");
        String employeeName = scanner.nextLine();

        System.out.println("Please input employee surname");
        String employeeSurname = scanner.nextLine();

        System.out.println("Please input employee salary");
        double employeeSalary = Double.parseDouble(scanner.nextLine());

        System.out.println("Please input employee company");
        String employeeCompany = scanner.nextLine();

        System.out.println("Please input employee position");
        String employeePosition = scanner.nextLine();

        employeeStorage.changeEmployeeById(employeeID, employeeName,
                employeeSurname, employeeSalary, employeeCompany, employeePosition);

        System.out.println("Employee changed.");
    }

    private static void deleteByID(Scanner scanner, EmployeeStorage employeeStorage) {
        System.out.println("Please input employee ID");
        String employeeID = scanner.nextLine();
        employeeStorage.deleteById(employeeID);
        System.out.println("Employee deleted.");
    }

    private static void searchByCompanyName(Scanner scanner, EmployeeStorage employeeStorage) {
        System.out.println("Please input company name");
        String keyword = scanner.nextLine();
        employeeStorage.searchByCompanyName(keyword);
    }

    private static void searchByID(Scanner scanner, EmployeeStorage employeeStorage) {
        System.out.println("Please input employee ID");
        String employeeID = scanner.nextLine();
        employeeStorage.searchByID(employeeID);
    }

    private static void addEmployee(Scanner scanner, EmployeeStorage employeeStorage) {
        System.out.println("Please input employee name");
        String name = scanner.nextLine();

        System.out.println("Please input employee surname");
        String surname = scanner.nextLine();

        System.out.println("Please input employee ID");
        String employeeID = scanner.nextLine();

        System.out.println("Please input employee salary");
        double salary = Double.parseDouble(scanner.nextLine());

        System.out.println("Please input employee company");
        String company = scanner.nextLine();

        System.out.println("Please input employee position");
        String position = scanner.nextLine();

        Employee employee = new Employee(name, surname, employeeID, salary, company, position);
        employeeStorage.add(employee);
        System.out.println("Employee created.");
    }

    private static void printCommands() {
        System.out.println("Please input 0 for EXIT");
        System.out.println("Please input 1 for ADD EMPLOYEE");
        System.out.println("Please input 2 for PRINT ALL EMPLOYEES");
        System.out.println("Please input 3 for SEARCH EMPLOYEE BY EMPLOYEE ID");
        System.out.println("Please input 4 for SEARCH EMPLOYEE BY COMPANY NAME");
        System.out.println("Please input 5 for DELETE EMPLOYEE BY EMPLOYEE ID");
        System.out.println("Please input 6 for CHANGE EMPLOYEE BY EMPLOYEE ID");
    }
}
