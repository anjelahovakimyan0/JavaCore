package classwork.lesson8;

public class IntExample {

    public static void main(String[] args) {
        int a = 5;

        String aStr = String.valueOf(a);
        System.out.println(aStr);

        String aStr2 = a + "";
        System.out.println(aStr2);

        System.out.println();

        String s = "567";
        int sInt = Integer.parseInt(s);
        System.out.println(sInt * 2);
    }

}
