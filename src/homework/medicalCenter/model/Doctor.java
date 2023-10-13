package homework.medicalCenter.model;

public class Doctor extends Person {

    private String email;
    private String profession;

    public Doctor() {
    }

    public Doctor(String id, String name, String surname, String phoneNumber, String email, String profession) {
        super(id, name, surname, phoneNumber);
        this.email = email;
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Doctor{" + super.toString() +
                "email='" + email + '\'' +
                ", profession='" + profession + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        super.equals(o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Doctor doctor = (Doctor) o;

        if (email != null ? !email.equals(doctor.email) : doctor.email != null) return false;
        return profession != null ? profession.equals(doctor.profession) : doctor.profession == null;
    }

    @Override
    public int hashCode() {
        super.hashCode();
        int result = super.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        return result;
    }
}
