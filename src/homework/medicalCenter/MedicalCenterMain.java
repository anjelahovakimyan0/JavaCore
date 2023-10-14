package homework.medicalCenter;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.storage.DoctorStorage;
import homework.medicalCenter.storage.PatientStorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MedicalCenterMain {

    private static Scanner scanner = new Scanner(System.in);
    private static DoctorStorage doctorStorage = new DoctorStorage();
    private static PatientStorage patientStorage = new PatientStorage();
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public static void main(String[] args) throws ParseException {
        boolean isRun = true;

        while (isRun) {
            printCommands();

            String command = scanner.nextLine();

            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addDoctor();
                    break;
                case "2":
                    searchDoctorByProfession();
                    break;
                case "3":
                    deleteDoctorById();
                    break;
                case "4":
                    changeDoctorById();
                    break;
                case "5":
                    doctorStorage.printAllDoctors();
                    break;
                case "6":
                    addPatient();
                    break;
                case "7":
                    deletePatientById();
                    break;
                case "8":
                    changePatientById();
                    break;
                case "9":
                    printAllPatientsByDoctor();
                    break;
                case "10":
                    patientStorage.printAllPatients();
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
        Doctor doctorFromStorage = doctorStorage.getById(id);
        if (doctorFromStorage != null) {
            System.out.println("Doctor with " + id + " id already exists.");
            return;
        }
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
        doctorStorage.add(doctor);
        System.out.println("Doctor created.");
    }

    private static void searchDoctorByProfession() {
        System.out.println("Please input doctor profession");
        String profession = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.searchDoctorByProfession(profession);
        if (doctorFromStorage == null) {
            System.out.println("Doctor does not exists.");
            return;
        }
        System.out.println(doctorFromStorage);
    }

    private static void deleteDoctorById() {
        System.out.println("Please input doctor id");
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with " + doctorId + " id does not exists.");
            return;
        }
        doctorStorage.deleteById(doctorId);
        patientStorage.deletePatientsByDoctorId(doctorId);
        System.out.println("Doctor is deleted.");
    }

    private static void changeDoctorById() {
        System.out.println("Please input doctor id");
        String id = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(id);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with " + id + " id does not exists.");
            return;
        }
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
        doctorFromStorage.setName(name);
        doctorFromStorage.setSurname(surname);
        doctorFromStorage.setPhoneNumber(phoneNumber);
        doctorFromStorage.setEmail(email);
        doctorFromStorage.setProfession(profession);
        System.out.println("Doctor is updated.");
    }

    private static void addPatient() throws ParseException {
        System.out.println("Please choose doctor id");
        doctorStorage.printAllDoctors();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with " + doctorId + " id does not exists.");
            return;
        }
        System.out.println("Please input patient id");
        String patientId = scanner.nextLine();
        Patient patient = patientStorage.getPatientById(patientId);
        if (patient != null) {
            System.out.println("Patient with " + patientId + " id already exists.");
            return;
        }
        System.out.println("Please input name");
        String name = scanner.nextLine();
        System.out.println("Please input surname");
        String surname = scanner.nextLine();
        System.out.println("Please input phoneNumber");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please input register date time");
        Date registerDateTime = sdf.parse(scanner.nextLine());
        patient = new Patient(patientId, name, surname, phoneNumber,
                doctorFromStorage, registerDateTime);
        patientStorage.add(patient);
        System.out.println("Patient registered.");
    }

    private static void deletePatientById() {
        System.out.println("Please input patient id");
        patientStorage.printAllPatients();
        String patientId = scanner.nextLine();
        Patient patient = patientStorage.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient with " + patientId + " id does not exists.");
            return;
        }
        patientStorage.deletePatientById(patientId);
        System.out.println("Patient is deleted.");
    }

    private static void changePatientById() throws ParseException {
        System.out.println("Please input patient id");
        String patientId = scanner.nextLine();
        Patient patient = patientStorage.getPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient with " + patientId + " id does not exists.");
            return;
        }
        System.out.println("Please choose new doctor id");
        doctorStorage.printAllDoctors();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with " + doctorId + " id does not exists.");
            return;
        }
        System.out.println("Please input new name");
        String name = scanner.nextLine();
        System.out.println("Please input new surname");
        String surname = scanner.nextLine();
        System.out.println("Please input new phoneNumber");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please input update date time");
        Date updateDateTime = sdf.parse(scanner.nextLine());
        patient.setName(name);
        patient.setSurname(surname);
        patient.setPhoneNumber(phoneNumber);
        patient.setDoctor(doctorFromStorage);
        patient.setRegisterDateTime(updateDateTime);
        System.out.println("Patient is updated.");
    }

    private static void printAllPatientsByDoctor() {
        System.out.println("Please choose doctor id");
        doctorStorage.printAllDoctors();
        String doctorId = scanner.nextLine();
        Doctor doctorFromStorage = doctorStorage.getById(doctorId);
        if (doctorFromStorage == null) {
            System.out.println("Doctor with " + doctorId + " id does not exists.");
            return;
        }
        patientStorage.printAllPatientsByDoctor(doctorFromStorage);
    }

    private static void printCommands() {
        System.out.println("Please input 0 for EXIT");
        System.out.println("Please input 1 for ADD_DOCTOR");
        System.out.println("Please input 2 for SEARCH_DOCTOR_BY_PROFESSION");
        System.out.println("Please input 3 for DELETE_DOCTOR_BY_ID");
        System.out.println("Please input 4 for CHANGE_DOCTOR_BY_ID");
        System.out.println("Please input 5 for PRINT_ALL_DOCTORS");
        System.out.println("Please input 6 for ADD_PATIENT");
        System.out.println("Please input 7 for DELETE_PATIENT_BY_ID");
        System.out.println("Please input 8 for CHANGE_PATIENT_BY_ID");
        System.out.println("Please input 9 for PRINT_ALL_PATIENTS_BY_DOCTOR");
        System.out.println("Please input 10 for PRINT_ALL_PATIENTS");
    }
}
