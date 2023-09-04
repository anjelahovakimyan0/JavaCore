package classwork.chapter5.lesson10;

public class SwitchExample {

    public static void main(String[] args) {
        String lang = "hy";

        switch (lang) {
            case "HY":
            case "hy":
            case "ARM":
            case "arm":
                System.out.println("Բարև");
                break;
            case "RU":
                System.out.println("Привет");
                break;
            case "ENG":
                System.out.println("Hello");
                break;
            default:
                System.out.println("Language is not supported!");
        }

        if(lang.equals("ARM")) {
            System.out.println("Բարև");
        } else if (lang.equals("RU")) {
            System.out.println("Привет");
        } else if (lang.equals("ENG")) {
            System.out.println("Hello");
        } else {
            System.out.println("Language is not supported!");
        }
    }
}
