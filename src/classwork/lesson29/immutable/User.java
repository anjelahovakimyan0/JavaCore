package classwork.lesson29.immutable;

import java.util.Collections;
import java.util.List;

public class User {

    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final List<String> languageList;

    public User(String name, String surname, String email, String password, List<String> languageList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.languageList = Collections.unmodifiableList(languageList);
//        this.languageList = new ArrayList<>(languageList);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getLanguageList() {
        return languageList;
//        return new ArrayList<>(languageList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return languageList != null ? languageList.equals(user.languageList) : user.languageList == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (languageList != null ? languageList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", languageList=" + languageList +
                '}';
    }
}
