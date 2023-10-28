package homework.onlineShop.commands;

public interface AdminCommand {

    String EXIT = "0";
    String ADD_PRODUCT = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_PRODUCTS = "3";
    String PRINT_USERS= "4";
    String PRINT_ORDERS= "5";
    String CHANGE_ORDER_STATUS= "6";
    String LOGOUT= "7";

    static void printCommands() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + ADD_PRODUCT + " for add product");
        System.out.println("Please input " + REMOVE_PRODUCT_BY_ID + " for remove product by id");
        System.out.println("Please input " + PRINT_PRODUCTS + " for print products");
        System.out.println("Please input " + PRINT_USERS + " for print users");
        System.out.println("Please input " + PRINT_ORDERS + " for print orders");
        System.out.println("Please input " + CHANGE_ORDER_STATUS + " for change order status");
        System.out.println("Please input " + LOGOUT + " for logout");
    }
}
