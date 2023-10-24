package homework.medicalCenter.storage;

import homework.medicalCenter.exception.NoValidDateException;
import homework.medicalCenter.exception.PersonExistsException;
import homework.medicalCenter.exception.PersonNotFoundException;
import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;

import java.util.Calendar;
import java.util.Date;

public class PersonStorage {

    private Person[] people = new Person[10];
    private int size;

    public void add(Person person) throws PersonExistsException {
        for (int i = 0; i < size; i++) {
            if ((person instanceof Doctor && people[i].getId().equals(person.getId()))
                    || (person instanceof Patient && people[i].getId().equals(person.getId()))) {
                throw new PersonExistsException("Person with " + person.getId() + " id already exists");
            }
        }
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

    public Doctor getDoctorById(String doctorId) throws PersonNotFoundException {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor doctor && people[i].getId().equals(doctorId)) {
                return doctor;
            }
        }
        throw new PersonNotFoundException("Doctor with " + doctorId + " does not found!");
    }

    public Patient getPatientById(String patientId) throws PersonNotFoundException {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient patient && people[i].getId().equals(patientId)) {
                return patient;
            }
        }
        throw new PersonNotFoundException("Patient with " + patientId + " does not found!");
    }

    public Doctor searchDoctorByProfession(String profession) throws PersonNotFoundException {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor doctor && ((Doctor) people[i]).getProfession().equals(profession)) {
                return doctor;
            }
        }
        throw new PersonNotFoundException("Doctor does not exists");
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

    public void deletePatientsByDoctorId(String doctorId) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient && ((Patient) people[i]).getDoctor().getId().equals(doctorId)) {
                for (int j = i + 1; j < size; j++) {
                    people[j - 1] = people[j];
                }
                size--;
            }
        }
    }

    public void changeDoctorById(String id, String name, String surname, String phoneNumber, String email, String profession) throws PersonNotFoundException {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Doctor doctor && people[i].getId().equals(id)) {
                doctor.setName(name);
                doctor.setSurname(surname);
                doctor.setPhoneNumber(phoneNumber);
                doctor.setEmail(email);
                doctor.setProfession(profession);
                return;
            }
        }
        throw new PersonNotFoundException("Person with " + id + " does not exists");
    }

    public void changePatientById(String patientId, String name, String surname, String phoneNumber, Doctor doctor, Date updateDateTime) {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient patient && people[i].getId().equals(patientId)) {
                patient.setName(name);
                patient.setSurname(surname);
                patient.setPhoneNumber(phoneNumber);
                patient.setDoctor(doctor);
                patient.setRegisterDateTime(updateDateTime);
            }
        }
    }

    public void isPersonExists(String id) throws PersonExistsException {
        for (int i = 0; i < size; i++) {
            if((people[i] instanceof Doctor && people[i].getId().equals(id))
                    || people[i] instanceof Patient && people[i].getId().equals(id)) {
                throw new PersonExistsException("Person with " + id + " id already exists");
            }
        }
    }

    public boolean isValidDate(Doctor doctor, Date appointmentDateTime) throws NoValidDateException {
        for (int i = 0; i < size; i++) {
            if (people[i] instanceof Patient patient) {
                if (patient.getDoctor().equals(doctor)) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(patient.getAppointmentDateTime());
                    calendar.add(Calendar.MINUTE, 29);
                    Date appointmentDatePlus30 = calendar.getTime();
                    if (appointmentDateTime.before(appointmentDatePlus30)) {
                        throw new NoValidDateException("Error: date is invalid. Please choose appointment date after " + appointmentDatePlus30);
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
