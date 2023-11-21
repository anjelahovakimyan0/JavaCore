package classwork.chapter14;

public class OverrideDemo {

    public static void main(String[] args) {
        Gen3<Integer> iOb = new Gen3<>(88);

        Gen4<Integer> iOb2 = new Gen4<>(99);

        Gen4<String> strOb2 = new Gen4<>("Тест обобщений");

        System.out.println(iOb.getOb());
        System.out.println(iOb2.getOb());
        System.out.println(strOb2.getOb());
    }
}
