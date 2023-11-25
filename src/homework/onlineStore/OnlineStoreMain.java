package homework.onlineStore;

import homework.onlineStore.command.Command;
import homework.onlineStore.model.*;
import homework.onlineStore.model.enums.OrderStatus;
import homework.onlineStore.model.enums.PaymentMethod;
import homework.onlineStore.model.enums.ProductType;
import homework.onlineStore.model.enums.UserType;
import homework.onlineStore.storage.*;
import homework.onlineStore.util.*;

import java.util.Date;
import java.util.Scanner;

public class OnlineStoreMain implements Command {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final UserStorage USER_STORAGE = StorageSerializeUtil.deserializeUserStorage();
    private static final ProductStorage PRODUCT_STORAGE = StorageSerializeUtil.deserializeProductStorage();
    private static final OrderStorage ORDER_STORAGE = StorageSerializeUtil.deserializeOrderStorage();

    private static User currentUser = null;

    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            Command.printMainCommands();
            String command = SCANNER.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    private static void userCommands() {
        boolean isRun = true;
        while (isRun) {
            Command.printUserCommands();
            String command = SCANNER.nextLine();
            switch (command) {
                case Command.LOGOUT:
                    isRun = false;
                    currentUser = null;
                    break;
                case PRINT_PRODUCTS:
                    PRODUCT_STORAGE.print();
                    break;
                case BUY_PRODUCT:
                    buyProduct();
                    break;
                case PRINT_MY_ORDERS:
                    ORDER_STORAGE.printByUser(currentUser);
                    break;
                case CANCEL_ORDER_BY_ID:
                    cancelOrderById();
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    private static void adminCommands() {
        boolean isRun = true;
        while (isRun) {
            Command.printAdminCommands();
            String command = SCANNER.nextLine();
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_PRODUCT:
                    addProduct();
                    break;
                case REMOVE_PRODUCT_BY_ID:
                    removeProductById();
                    break;
                case PRINT_ALL_PRODUCTS:
                    PRODUCT_STORAGE.print();
                    break;
                case PRINT_USERS:
                    USER_STORAGE.printByType(UserType.USER);
                    break;
                case PRINT_ORDERS:
                    ORDER_STORAGE.print();
                    break;
                case CHANGE_ORDER_STATUS_BY_ID:
                    changeOrderStatus();
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    private static void login() {
        System.out.println("Please input user email");
        String email = SCANNER.nextLine();
        System.out.println("Please input user password");
        String password = SCANNER.nextLine();
        User user = USER_STORAGE.getByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("Email or password is incorrect");
            return;
        }
        currentUser = user;
        if (user.getType() == UserType.USER) {
            userCommands();
        } else {
            adminCommands();
        }
    }

    private static void register() {
        System.out.println("Please input user name");
        String name = SCANNER.nextLine();
        System.out.println("Please input user surname");
        String surname = SCANNER.nextLine();
        System.out.println("Please input user email");
        String email = SCANNER.nextLine();
        User user = USER_STORAGE.getByEmail(email);
        if (user != null) {
            System.out.println("User already exists!");
            return;
        }
        System.out.println("Please input user password");
        String password = SCANNER.nextLine();
        System.out.println("Please input user type (USER, ADMIN)");
        try {
            UserType userType = UserType.valueOf(SCANNER.nextLine());
            user = new User(IdGenerator.generateId(), name, surname, email, password, userType);
            USER_STORAGE.register(user);
            System.out.println("Register succeed!");
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal user type.");
        }
    }

    private static void addProduct() {
        System.out.println("Please input product name");
        String name = SCANNER.nextLine();
        System.out.println("Please input product description");
        String description = SCANNER.nextLine();
        try {
            System.out.println("Please input product price");
            double price = Double.parseDouble(SCANNER.nextLine());
            System.out.println("Please input product stock quantity");
            int stockQty = Integer.parseInt(SCANNER.nextLine());
            System.out.println("Please input product type (ELECTRONICS, CLOTHING, BOOKS)");
            ProductType type = ProductType.valueOf(SCANNER.nextLine());
            Product product = new Product(IdGenerator.generateId(), name, description, price, stockQty, type);
            PRODUCT_STORAGE.add(product);
            System.out.println("Product added.");
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal data " + e.getMessage());
        }
    }

    private static void removeProductById() {
        PRODUCT_STORAGE.print();
        System.out.println("Please input product id");
        String productId = SCANNER.nextLine();
        Product product = PRODUCT_STORAGE.getById(productId);
        if (product == null) {
            System.out.println("Product with " + productId + " does not exists");
            return;
        }
        PRODUCT_STORAGE.delete(productId);
        StorageSerializeUtil.serializeProductStorage(PRODUCT_STORAGE);
        System.out.println("Product removed");
    }

    private static void buyProduct() {
        PRODUCT_STORAGE.print();
        System.out.println("Please input product id");
        String productId = SCANNER.nextLine();
        Product product = PRODUCT_STORAGE.getById(productId);
        if (product == null) {
            System.out.println("Product with " + productId + " does not exists");
            return;
        }
        System.out.println("Please input order quantity");
        int orderQty;
        try {
            orderQty = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect format. Please input only numbers");
            return;
        }
        if (product.getStockQty() < orderQty) {
            System.out.println("Wrong quantity");
            return;
        }
        System.out.println("Please input payment method (CARD, CASH, PAYPAL)");
        PaymentMethod paymentMethod = PaymentMethod.valueOf(SCANNER.nextLine());
        System.out.println("You want to buy this products with this quantity " + orderQty + " and price " + "$" +
                (product.getPrice() * orderQty) + ", paymentMethod: " + paymentMethod + "\nAre you sure? (Yes/No)");
        String answer = SCANNER.nextLine();
        if (!answer.equalsIgnoreCase("yes")) {
            System.out.println("Order canceled!");
            return;
        }
        Order order = new Order(IdGenerator.generateId(), currentUser, product, new Date(),
                product.getPrice(), OrderStatus.NEW, orderQty, paymentMethod);
        ORDER_STORAGE.add(order);
        product.setStockQty(product.getStockQty() - orderQty);
        StorageSerializeUtil.serializeProductStorage(PRODUCT_STORAGE);
        System.out.println("Order succeed.");
    }

    private static void cancelOrderById() {
        ORDER_STORAGE.printByUser(currentUser);
        System.out.println("Please input orderId");
        String orderId = SCANNER.nextLine();
        Order order = ORDER_STORAGE.getById(orderId);
        if (order == null || !order.getUser().equals(currentUser)) {
            System.out.println("Wrong order id!");
            return;
        }
        if (order.getOrderStatus() != OrderStatus.NEW) {
            System.out.println("Order can not be canceled!");
            return;
        }
        order.setOrderStatus(OrderStatus.CANCELED);
        StorageSerializeUtil.serializeOrderStorage(ORDER_STORAGE);
        order.getProduct().setStockQty(order.getProduct().getStockQty() + order.getQty());
        StorageSerializeUtil.serializeProductStorage(PRODUCT_STORAGE);
        System.out.println("Order canceled!");
    }

    private static void changeOrderStatus() {
        ORDER_STORAGE.print();
        System.out.println("Please input order id");
        String orderId = SCANNER.nextLine();
        System.out.println("Please input new order status(NEW, DELIVERED, CANCELED)");
        OrderStatus newOrderStatus = OrderStatus.valueOf(SCANNER.nextLine());
        Order order = ORDER_STORAGE.getById(orderId);
        if (order == null) {
            System.out.println("Order with " + orderId + " does not exists");
            return;
        }
        if (order.getOrderStatus().equals(OrderStatus.NEW)
                && newOrderStatus.equals(OrderStatus.DELIVERED)) {
            if (order.getProduct().getStockQty() < order.getQty()) {
                System.out.println("You do not have enough product quantity");
                return;
            }
            order.getProduct().setStockQty(order.getProduct().getStockQty() - order.getQty());
            order.setOrderStatus(newOrderStatus);
            StorageSerializeUtil.serializeOrderStorage(ORDER_STORAGE);
            System.out.println("Order status has changed!");
        }
    }
}
