package classwork.lesson24;

import homework.onlineShop.model.Language;

public class UserTest {

    public static void main(String[] args) {
        String langEng = "ENG";
        Language language = Language.valueOf(langEng);
        User user = new User("Poxos", "Poxosyan", "poxos@gmail.com", Language.HY);
        User user1 = new User("Petros", "Petrosyan", "petros@gmail.com", Language.RU);
        User user2 = new User("Martiros", "Martirosyan", "martiros@gmail.com", language);
        String lang = user1.getLang().name();
        System.out.println(user);
        System.out.println(lang);
        System.out.println(user2);

        System.out.println(Language.HY.ordinal());

        Language[] values = Language.values();
        for (Language value : values) {
            System.out.println(value + " " + value.getLanguageName() + " " + value.ordinal());
        }
    }
}
