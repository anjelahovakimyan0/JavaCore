package classwork.lesson22;

public class StringUtil {

    static String checkString(String s) throws Exception {
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                result = false;
                break;
            }
        }
        if (result) {
            return s.toUpperCase();
        }
        throw new Exception("String contains digit");
    }
}
