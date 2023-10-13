package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;

public class DoctorStorage {

    private Doctor[] doctors = new Doctor[10];
    private int size;

    public void add(Doctor doctor) {
        if (size == doctors.length) {
            extend();
        }
        doctors[size++] = doctor;
    }

    public Doctor getById(String id) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(id)) {
                return doctors[i];
            }
        }
        return null;
    }

    public void printAllDoctors() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i]);
        }
    }

    public Doctor searchDoctorByProfession(String profession) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession().equals(profession)) {
                return doctors[i];
            }
        }
        return null;
    }

    public Doctor searchDoctorById(String id) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(id)) {
                return doctors[i];
            }
        }
        return null;
    }

    public void deleteById(String id) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(id)) {
                for (int j = i + 1; j < size; j++) {
                    doctors[j - 1] = doctors[j];
                }
                size--;
            }
        }
    }

    private void extend() {
        Doctor[] tmp = new Doctor[doctors.length + 10];
        System.arraycopy(doctors, 0, tmp, 0, doctors.length);
        doctors = tmp;
    }
}
