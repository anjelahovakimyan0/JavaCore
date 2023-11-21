package classwork.lesson29.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CollectionExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Poxos");
        names.add("Poxos");
        names.add("Poxos");
        names.add("Petros");
        names.add("Petros");
        names.add("Petros");
        names.add("Petros");
        names.add("Petros");
        names.add("Martiros");
        names.add("Martiros");
        names.add("Martiros");
        names.add("Martiros");
        names.add("Zaven");

        System.out.println(uniqueNameCount(names));
    }

    public static int uniqueNameCount(List<String> names) {
        return new HashSet<>(names).size();

//        List<String> uniqueNames = new ArrayList<>();
//        for (String name : names) {
//            if (!uniqueNames.contains(name)) {
//                uniqueNames.add(name);
//            }
//        }
//        return uniqueNames.size();
    }
}
