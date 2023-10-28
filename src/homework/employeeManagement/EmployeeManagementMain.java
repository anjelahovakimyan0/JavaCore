package homework.employeeManagement;

import homework.employeeManagement.exception.EmployeeNotFoundException;
import homework.employeeManagement.model.Company;
import homework.employeeManagement.model.Employee;
import homework.employeeManagement.storage.CompanyStorage;
import homework.employeeManagement.storage.EmployeeStorage;
import homework.employeeManagement.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class EmployeeManagementMain implements Command {

    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();
    private static CompanyStorage companyStorage = new CompanyStorage();

    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            Command.printCommands();

            String command = scanner.nextLine();

            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_COMPANY:
                    addCompany();
                    break;
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;
                case PRINT_COMPANIES:
                    companyStorage.print();
                    break;
                case PRINT_EMPLOYEES:
                    employeeStorage.print();
                    break;
                case SEARCH_EMPLOYEE_BY_ID:
                    searchEmployeeById();
                    break;
                case SEARCH_EMPLOYEE_BY_COMPANY:
                    searchEmployeeByCompany();
                    break;
                case DELETE_COMPANY:
                    deleteCompany();
                    break;
                case DELETE_EMPLOYEE:
                    deleteEmployee();
                    break;
                case CHANGE_COMPANY:
                    changeCompany();
                    break;
                case CHANGE_EMPLOYEE:
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
        if (companyFromStorage == null) {
            System.out.println("Company with " + companyId + " dose not exists!!!");
            return;
        }
        employeeStorage.searchEmployeesByCompany(companyFromStorage);
        System.out.println("Please input employee id");
        String employeeId = scanner.nextLine();
        try {
            Employee employeeFromStorage = employeeStorage.getById(employeeId);
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
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Wrong salary, please input only numbers!");
        }
    }

    private static void changeCompany() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
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
        if (companyFromStorage == null) {
            System.out.println("Company with " + companyId + " id does not exists!!!");
            return;
        }
        employeeStorage.searchEmployeesByCompany(companyFromStorage);

        System.out.println("Please input employee id");
        String employeeId = scanner.nextLine();
        try {
            Employee employeeFromStorage = employeeStorage.getById(employeeId);
            if (!employeeFromStorage.getCompany().equals(companyFromStorage)) {
                System.out.println("Wrong employee id");
                return;
            }
            employeeStorage.deleteById(employeeId);
            System.out.println("Employee deleted.");
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addCompany() {
        System.out.println("Please input company id");
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage != null) {
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
        if (companyFromStorage == null) {
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
        if (companyFromStorage == null) {
            System.out.println("Company with " + companyId + " does not exists!!!");
            return;
        }
        employeeStorage.searchEmployeesByCompany(companyFromStorage);
    }

    private static void searchEmployeeById() {
        System.out.println("Please input employee Id");
        String employeeId = scanner.nextLine();
        try {
            System.out.println(employeeStorage.getById(employeeId));
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addEmployee() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if (companyFromStorage == null) {
            System.out.println("Company with " + companyId + " does not exists!!!");
            return;
        }
        System.out.println("Please input employee id");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage;
        boolean exists;
        try {
            employeeFromStorage = employeeStorage.getById(employeeId);
            exists = true;
        } catch (EmployeeNotFoundException e) {
            exists = false;
        }
        if (!exists) {
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
            System.out.println("Please input employee date of birthday (dd/MM/yyyy)");
            String dateOfBirthdayStr = scanner.nextLine();
            Date dateOfBirthday = null;
            try {
                dateOfBirthday = DateUtil.stringToDate(dateOfBirthdayStr);
            } catch (ParseException e) {
                System.out.println("Date of birthday is incorrect!");
            }
            Date registerDate = new Date();
            Employee employee = new Employee(employeeId, name, surname, phone,
                    salary, position, companyFromStorage, dateOfBirthday, registerDate);
            employeeStorage.add(employee);
            System.out.println("Employee registered.");
        } else {
            System.out.println("Employee already exists!");
        }
    }
}

