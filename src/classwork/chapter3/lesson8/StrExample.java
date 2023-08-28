package classwork.chapter3.lesson8;

public class StrExample {

    public static void main(String[] args) {
        char[] name = {'p', 'o', 'x', 'o', 's'};
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i]);
        }

        System.out.println();

        String nameStr = "Poxos";
        char[] chars = nameStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }

        System.out.println();

        for (int i = 0; i < nameStr.length(); i++) {
            System.out.print(nameStr.charAt(i));
        }

        System.out.println();

        String charStr = new String(name);
        System.out.println(charStr);
    }
}
