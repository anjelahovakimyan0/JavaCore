package homework.medicalCenter.model;

import java.util.Date;
import java.util.Objects;

public class Patient extends Person {

    private Doctor doctor;
    private Date registerDateTime;

    public Patient() {
    }

    public Patient(String id, String name, String surname, String phoneNumber, Doctor doctor, Date registerDateTime) {
        super(id, name, surname, phoneNumber);
        this.doctor = doctor;
        this.registerDateTime = registerDateTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(Date registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    @Override
    public String toString() {
        return "Patient{" + super.toString() +
                ", registerDateTime=" + registerDateTime +
                ", doctor=" + doctor +
                "} ";
    }
}
