package homework.onlineShop;

public interface Command {

    String LOGOUT = "0";
    String BUY_PRODUCT = "1";
    String PRINT_PRODUCTS = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";

    String ADD_PRODUCT = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_ALL_PRODUCTS = "3";
    String PRINT_USERS = "4";
    String PRINT_ORDERS = "5";
    String CHANGE_ORDER_STATUS = "6";

    String EXIT = "0";
    String LOGIN = "1";
    String REGISTER = "2";

    static void printCommands() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + LOGIN + " for login");
        System.out.println("Please input " + REGISTER + " for register");
    }

    static void printUserCommands() {
        System.out.println("Please input " + LOGOUT + " for logout");
        System.out.println("Please input " + BUY_PRODUCT + " for buy products");
        System.out.println("Please input " + PRINT_PRODUCTS + " for print products");
        System.out.println("Please input " + PRINT_MY_ORDERS + " for print your orders");
        System.out.println("Please input " + CANCEL_ORDER_BY_ID + " for cancel order by id");
    }

    static void printAdminCommands() {
        System.out.println("Please input " + LOGOUT + " for logout");
        System.out.println("Please input " + ADD_PRODUCT + " for add product");
        System.out.println("Please input " + REMOVE_PRODUCT_BY_ID + " for remove product by id");
        System.out.println("Please input " + PRINT_ALL_PRODUCTS + " for print products");
        System.out.println("Please input " + PRINT_USERS + " for print users");
        System.out.println("Please input " + PRINT_ORDERS + " for print orders");
        System.out.println("Please input " + CHANGE_ORDER_STATUS + " for change order status");
    }
}
