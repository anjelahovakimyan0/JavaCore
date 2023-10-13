package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;

public class PatientStorage {

    private Patient[] patients = new Patient[10];
    private int size;

    public void add(Patient patient) {
        if (size == patients.length) {
            extend();
        }
        patients[size++] = patient;
    }

    public Patient getPatientById(String patientId) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getId().equals(patientId)) {
                return patients[i];
            }
        }
        return null;
    }

    public void printAllPatientsByDoctor(Doctor doctor) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getDoctor().equals(doctor)) {
                System.out.println(patients[i]);
            }
        }
    }

    public void deletePatientsByDoctorId(String doctorId) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getDoctor().getId().equals(doctorId)) {
                for (int j = i + 1; j < size; j++) {
                    patients[j - 1] = patients[j];
                }
                size--;
            }
        }
    }

    public void deletePatientsById(String patientId) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getId().equals(patientId)) {
                for (int j = i + 1; j < size; j++) {
                    patients[j - 1] = patients[j];
                }
                size--;
            }
        }
    }

    public void printAllPatients() {
        for (int i = 0; i < size; i++) {
            System.out.println(patients[i]);
        }
    }

    private void extend() {
        Patient[] tmp = new Patient[patients.length + 10];
        System.arraycopy(patients, 0, tmp, 0, patients.length);
        patients = tmp;
    }
}
