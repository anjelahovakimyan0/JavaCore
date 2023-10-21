package homework.medicalCenter;

public interface Command {

    String EXIT = "0";
    String ADD_DOCTOR = "1";
    String SEARCH_DOCTOR_BY_PROFESSION = "2";
    String DELETE_DOCTOR_BY_ID = "3";
    String CHANGE_DOCTOR_BY_ID = "4";
    String PRINT_DOCTORS = "5";
    String ADD_PATIENT = "6";
    String DELETE_PATIENT_BY_ID = "7";
    String CHANGE_PATIENT_BY_ID = "8";
    String PRINT_PATIENTS_BY_DOCTOR = "9";
    String PRINT_PATIENTS = "10";

    static void printCommands() {
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
