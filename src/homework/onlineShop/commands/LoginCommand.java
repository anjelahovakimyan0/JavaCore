package homework.onlineShop.commands;

public interface LoginCommand {

    String LOGIN = "0";
    String REGISTER = "1";

    static void printCommands() {
        System.out.println("Please input " + LOGIN + " for login");
        System.out.println("Please input " + REGISTER + " for register");
    }
}
