package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;

import java.text.ParseException;
import java.util.Date;

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

    public void deletePatientByDoctorId(String doctorId) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getDoctor().getId().equals(doctorId)) {
                for (int j = i + 1; j < size; j++) {
                    patients[j - 1] = patients[j];
                }
                size--;
            }
        }
    }

    public void deletePatientById(String patientId) {
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

    public boolean IsDoctorFree(Doctor doctor, Date registerDateTime) throws ParseException {
        for (int i = 0; i < size; i++) {
            if (patients[i].getDoctor().equals(doctor) &&
                    !patients[i].getRegisterDateTime().equals(registerDateTime)) {
                if (patients[i].getRegisterDateTime().getDate() == registerDateTime.getDate()) {
                    if (patients[i].getRegisterDateTime().before(registerDateTime)) {
                        long milliSeconds = registerDateTime.getTime() - patients[i].getRegisterDateTime().getTime();
                        long minutes = (long) (milliSeconds * 0.001 * 0.0166667);
                        if (minutes >= 30) {
                            return true;
                        }
                    } else if (patients[i].getRegisterDateTime().after(registerDateTime)) {
                        long milliseconds = patients[i].getRegisterDateTime().getTime() - registerDateTime.getTime();
                        long minutes = (long) (milliseconds * 0.001 * 0.0166667);
                        if (minutes >= 30) {
                            return true;
                        }
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isStorageEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    private void extend() {
        Patient[] tmp = new Patient[patients.length + 10];
        System.arraycopy(patients, 0, tmp, 0, patients.length);
        patients = tmp;
    }
}
