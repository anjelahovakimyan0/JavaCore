package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;

import java.util.Calendar;
import java.util.Date;

public class PersonStorage {

    private Person[] people = new Person[10];
    private int size;

    public void add(Person person) {
        if (size == people.length) {
            extend();
        }
        people[size++] = person;
    }

    public void printDoctors() {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor) {
                System.out.println(people[i]);
            }
        }
    }

    public void printPatients() {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient) {
                System.out.println(people[i]);
            }
        }
    }

    public Person getDoctorById(String doctorId) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor && people[i].getId().equals(doctorId)) {
                return people[i];
            }
        }
        return null;
    }

    public Person getPatientById(String patientId) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient && people[i].getId().equals(patientId)) {
                return people[i];
            }
        }
        return null;
    }

    public Person searchDoctorByProfession(String profession) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor && ((Doctor) people[i]).getProfession().equals(profession)) {
                return people[i];
            }
        }
        return null;
    }

    public void deleteDoctorById(String doctorId) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor && people[i].getId().equals(doctorId)) {
                for (int j = i + 1; j < size; j++) {
                    people[j - 1] = people[j];
                }
                size--;
            }
        }
    }

    public void deletePatientById(String patientId) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient && people[i].getId().equals(patientId)) {
                for (int j = i + 1; j < size; j++) {
                    people[j - 1] = people[j];
                }
                size--;
            }
        }
    }

    public void printPatientsByDoctor(Doctor doctor) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient && ((Patient) people[i]).getDoctor().equals(doctor)) {
                System.out.println(people[i]);
            }
        }
    }

    public void deletePatientByDoctorId(String doctorId) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient && ((Patient) people[i]).getDoctor().getId().equals(doctorId)) {
                for (int j = i + 1; j < size; j++) {
                    people[j - 1] = people[j];
                }
                size--;
            }
        }
    }

    public boolean isValidDate(Doctor doctor, Date appointmentDateTime) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient patient) {
                if (patient.getDoctor().equals(doctor)) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(patient.getAppointmentDateTime());
                    calendar.add(Calendar.MINUTE, 29);
                    Date appointmentDatePlus30 = calendar.getTime();
                    if (appointmentDateTime.before(appointmentDatePlus30)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void extend() {
        Person[] tmp = new Person[people.length + 10];
        System.arraycopy(people, 0, tmp, 0, people.length);
        people = tmp;
    }
}
