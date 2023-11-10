package classwork.lesson24;

import classwork.lesson25.annotation.FirstAnnotation;
import classwork.lesson25.annotation.Model;
import homework.onlineStore.model.enums.Language;

@Model(name = "User", val = 5)
public class User {

    @FirstAnnotation
    private String name;
    private String surname;
    private String email;
    private Language lang;

    public User() {
    }

    @FirstAnnotation
    public User(@FirstAnnotation String name, String surname, String email, Language lang) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    @FirstAnnotation
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    @Deprecated
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    @FirstAnnotation
    private static void printHello() {
        System.out.println("hello");
    }

    @Override
    @FirstAnnotation
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", lang=" + lang +
                '}';
    }
}
