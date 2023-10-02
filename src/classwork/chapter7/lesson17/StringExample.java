package classwork.chapter7.lesson17;

import java.util.Locale;

public class StringExample {

    public static void main(String[] args) {
        String name1 = "Poxos";
        String blankName = "";
        String name2 = "POxos";
        String fullName = "Poxos Poxosyan Poxosi";

        System.out.println(name1.equalsIgnoreCase(name2));

        System.out.println(name1.toLowerCase().equals(name2.toLowerCase()));

        String nameLower = name1.toLowerCase();
        System.out.println(nameLower);

        String nameUpper = name1.toUpperCase();
        System.out.println(nameUpper);

        boolean p = name1.startsWith("Po");
        System.out.println(p);

        boolean p2 = name1.endsWith("Po");
        System.out.println(p2);

        System.out.println(name1.contains("os"));

        if (blankName.isBlank()) {
            System.out.println("Name is blank");
        }

        String replacedFullName = fullName.replaceFirst(" ", "-");
        System.out.println(replacedFullName);

        String[] fullNameArray = fullName.split(" ");
        for (String s : fullNameArray) {
            System.out.println(s);
        }

        if (fullNameArray.length == 3) {
            String name = fullNameArray[0];
            String surname = fullNameArray[1];
            String middleName = fullNameArray[2];

            System.out.println(name);
            System.out.println(surname);
            System.out.println(middleName);
        }
    }
}
