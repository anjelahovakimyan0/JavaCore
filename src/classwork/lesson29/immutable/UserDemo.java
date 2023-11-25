package classwork.lesson29.immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDemo {

    public static void main(String[] args) {
        Map<User, Integer> userAttempt = new HashMap<>();

        List<String> langList = new ArrayList<>();
        langList.add("Arm");
        langList.add("Ru");
        User user = new User("poxos", "poxosyan", "poxos@gmail.com", "poxos", langList);

        System.out.println(user);
        System.out.println(user.hashCode());

        langList.add("Eng");
        System.out.println(user);
        System.out.println(user.hashCode());

        userAttempt.put(user, 1);
        langList.add("Eng");

        List<String> languageList = user.getLanguageList();
        languageList.add("Eng");

        System.out.println(userAttempt.get(user));
        System.out.println(user);
    }
}
