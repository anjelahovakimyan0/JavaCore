package classwork.lesson29;

import classwork.lesson24.User;
import homework.onlineStore.model.enums.Language;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        Map<String, User> myMap = new HashMap<>();

        myMap.put("poxos@gmail.com", new User("poxos", "poxosyan", "poxos@gmail.com", Language.HY));
        myMap.put("petros@gmail.com", new User("petros", "petrosyan", "petros@gmail.com", Language.HY));
        myMap.put(null, new User("petros", "petrosyan", "petros@gmail.com", Language.HY));

        for (String key : myMap.keySet()) {
            System.out.println(key + " -> " + myMap.get(key));
        }

        System.out.println("-----");

        for (User value : myMap.values()) {
            System.out.println(value);
        }

        System.out.println("-----");

        for (Map.Entry<String, User> stringUserEntry : myMap.entrySet()) {
            System.out.println(stringUserEntry);
            System.out.println();
            System.out.println(stringUserEntry.getKey() + " -> " + stringUserEntry.getValue());
        }

        System.out.println("-----");

        User user = myMap.get("petros@gmail.com");
        System.out.println(user);
    }
}
