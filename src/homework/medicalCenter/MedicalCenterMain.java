package homework.medicalCenter;

import homework.medicalCenter.exception.NoValidDateException;
import homework.medicalCenter.exception.PersonExistsException;
import homework.medicalCenter.exception.PersonNotFoundException;
import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.storage.PersonStorage;
import homework.medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class MedicalCenterMain implements Command {

    private static Scanner scanner = new Scanner(System.in);
    private static PersonStorage personStorage = new PersonStorage();

    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            Command.printCommands();

            String command = scanner.nextLine();

            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_DOCTOR:
                    addDoctor();
                    break;
                case SEARCH_DOCTOR_BY_PROFESSION:
                    searchDoctorByProfession();
                    break;
                case DELETE_DOCTOR_BY_ID:
                    deleteDoctorById();
                    break;
                case CHANGE_DOCTOR_BY_ID:
                    changeDoctorById();
                    break;
                case PRINT_DOCTORS:
                    personStorage.printDoctors();
                    break;
                case ADD_PATIENT:
                    addPatient();
                    break;
                case DELETE_PATIENT_BY_ID:
                    deletePatientById();
                    break;
                case CHANGE_PATIENT_BY_ID:
                    changePatientById();
                    break;
                case PRINT_PATIENTS_BY_DOCTOR:
                    printPatientsByDoctor();
                    break;
                case PRINT_PATIENTS:
                    personStorage.printPatients();
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    private static void addDoctor() {
        System.out.println("Please input doctor id");
        String id = scanner.nextLine();
        System.out.println("Please input doctor name");
        String name = scanner.nextLine();
        System.out.println("Please input doctor surname");
        String surname = scanner.nextLine();
        System.out.println("Please input doctor phoneNumber");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please input doctor email");
        String email = scanner.nextLine();
        System.out.println("Please input doctor profession");
        String profession = scanner.nextLine();
        Doctor doctor = new Doctor(id, name, surname, phoneNumber, email, profession);
        try {
            personStorage.add(doctor);
            System.out.println("Doctor created.");
        } catch (PersonExistsException e) {
            System.out.println(e);
        }
    }

    private static void searchDoctorByProfession() {
        System.out.println("Please input doctor profession");
        String profession = scanner.nextLine();
        try {
            Doctor doctorFromStorage = personStorage.searchDoctorByProfession(profession);
            System.out.println(doctorFromStorage);
        } catch (PersonNotFoundException e) {
            System.out.println(e);
        }
    }

    private static void deleteDoctorById() {
        System.out.println("Please input doctor id");
        String doctorId = scanner.nextLine();
        try {
            personStorage.getDoctorById(doctorId);
            personStorage.deleteDoctorById(doctorId);
            personStorage.deletePatientsByDoctorId(doctorId);
            System.out.println("Doctor is deleted.");
        } catch (PersonNotFoundException e) {
            System.out.println(e);
        }
    }

    private static void changeDoctorById() {
        System.out.println("Please input doctor id");
        String id = scanner.nextLine();
        System.out.println("Please input doctor name");
        String name = scanner.nextLine();
        System.out.println("Please input doctor surname");
        String surname = scanner.nextLine();
        System.out.println("Please input doctor phoneNumber");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please input doctor email");
        String email = scanner.nextLine();
        System.out.println("Please input doctor profession");
        String profession = scanner.nextLine();
        try {
            personStorage.changeDoctorById(id, name, surname, phoneNumber, email, profession);
            System.out.println("Doctor is updated.");
        } catch (PersonNotFoundException e) {
            System.out.println(e);
        }
    }

    private static void addPatient() {
        System.out.println("Please choose doctor id");
        personStorage.printDoctors();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = null;
        try {
            doctorFromStorage = personStorage.getDoctorById(doctorId);
        } catch (PersonNotFoundException e) {
            System.out.println(e);
            return;
        }
        System.out.println("Please input patient id");
        String patientId = scanner.nextLine();
        System.out.println("Please input name");
        String name = scanner.nextLine();
        System.out.println("Please input surname");
        String surname = scanner.nextLine();
        System.out.println("Please input phoneNumber");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please input appointment date time (dd/MM/yyyy hh:mm)");
        String appointmentDateTimeStr = scanner.nextLine();
        Date appointmentDateTime;
        try {
            appointmentDateTime = DateUtil.stringToDateTime(appointmentDateTimeStr);
        } catch (ParseException e) {
            System.out.println("Wrong date format. Please try again.");
            return;
        }
        boolean validDate;
        try {
            validDate = personStorage.isValidDate(doctorFromStorage, appointmentDateTime);
        } catch (NoValidDateException e) {
            System.out.println(e);
            return;
        }
        if (validDate) {
            Patient patient = new Patient(patientId, name, surname, phoneNumber,
                    doctorFromStorage, new Date(), appointmentDateTime);
            try {
                personStorage.add(patient);
                System.out.println("Patient registered.");
            } catch (PersonExistsException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Doctor is busy.");
        }
    }

    private static void deletePatientById() {
        System.out.println("Please input patient id");
        personStorage.printPatients();
        String patientId = scanner.nextLine();
        try {
            personStorage.getPatientById(patientId);
            personStorage.deletePatientById(patientId);
            System.out.println("Patient is deleted.");
        } catch (PersonNotFoundException e) {
            System.out.println(e);
        }
    }

    private static void changePatientById() {
        System.out.println("Please input patient id");
        String patientId = scanner.nextLine();
        try {
            personStorage.getPatientById(patientId);
        } catch (PersonNotFoundException e) {
            System.out.println(e);
            return;
        }
        System.out.println("Please choose new doctor id");
        personStorage.printDoctors();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage;
        try {
            doctorFromStorage = personStorage.getDoctorById(doctorId);
        } catch (PersonNotFoundException e) {
            System.out.println(e);
            return;
        }
        System.out.println("Please input new name");
        String name = scanner.nextLine();
        System.out.println("Please input new surname");
        String surname = scanner.nextLine();
        System.out.println("Please input new phoneNumber");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please input update date time (dd/MM/yyyy hh:mm)");
        try {
            Date updateDateTime = DateUtil.stringToDateTime(scanner.nextLine());
            personStorage.changePatientById(patientId, name, surname, phoneNumber, doctorFromStorage, updateDateTime);
            System.out.println("Patient is updated.");
        } catch (ParseException e) {
            System.out.println("Wrong date format. Please try again.");
        }
    }

    private static void printPatientsByDoctor() {
        System.out.println("Please choose doctor id");
        personStorage.printDoctors();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage;
        try {
            doctorFromStorage = personStorage.getDoctorById(doctorId);
            personStorage.printPatientsByDoctor(doctorFromStorage);
        } catch (PersonNotFoundException e) {
            System.out.println(e);
        }
    }
}
