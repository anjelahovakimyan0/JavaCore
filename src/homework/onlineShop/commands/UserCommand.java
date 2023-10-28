package homework.onlineShop.commands;

public interface UserCommand {

    String LOGOUT = "0";
    String PRINT_PRODUCTS = "1";
    String BUY_PRODUCT = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";
    String SET_ORDER_DELIVERED = "5";

    static void printCommand() {
        System.out.println("Please input " + LOGOUT + " for logout");
        System.out.println("Please input " + PRINT_PRODUCTS + " for print products");
        System.out.println("Please input " + BUY_PRODUCT + " for buy products");
        System.out.println("Please input " + PRINT_MY_ORDERS + " for print your orders");
        System.out.println("Please input " + CANCEL_ORDER_BY_ID + " for cancel order by id");
        System.out.println("Please input " + SET_ORDER_DELIVERED + " for say is order delivered or not");
    }
}
