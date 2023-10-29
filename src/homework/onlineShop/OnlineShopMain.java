package homework.onlineShop;

import homework.onlineShop.commands.*;
import homework.onlineShop.model.*;
import homework.onlineShop.storage.*;
import homework.onlineShop.exception.OutOfStockException;

import java.util.Date;
import java.util.Scanner;

public class OnlineShopMain implements LoginCommand, UserCommand, AdminCommand {

    private static Scanner scanner = new Scanner(System.in);
    private static UserStorage userStorage = new UserStorage();
    private static ProductStorage productStorage = new ProductStorage();
    private static OrderStorage orderStorage = new OrderStorage();

    public static void main(String[] args) {
        boolean isRegistered = false;
        boolean isRun = true;
        User user = null;

        while (isRun) {
            while (!isRegistered) {
                LoginCommand.printCommands();
                String command = scanner.nextLine();
                switch (command) {
                    case LOGIN:
                        user = login();
                        if (user != null) {
                            System.out.println("Successfully logined");
                            isRegistered = true;
                        }
                        break;
                    case REGISTER:
                        register();
                        break;
                    default:
                        System.out.println("Invalid command.");
                        break;
                }
            }

            if (user.getType().equals(UserType.ADMIN)) {
                AdminCommand.printCommands();
                String command = scanner.nextLine();
                switch (command) {
                    case EXIT:
                        isRun = false;
                        break;
                    case ADD_PRODUCT:
                        addProduct();
                        break;
                    case REMOVE_PRODUCT_BY_ID:
                        removeProductById();
                        break;
                    case AdminCommand.PRINT_PRODUCTS:
                        productStorage.printProducts();
                        break;
                    case PRINT_USERS:
                        userStorage.printUsers();
                        break;
                    case PRINT_ORDERS:
                        orderStorage.printOrders();
                        break;
                    case CHANGE_ORDER_STATUS:
                        orderStorage.changeOrderStatus();
                        break;
                    case AdminCommand.LOGOUT:
                        isRegistered = false;
                        break;
                    default:
                        System.out.println("Invalid command.");
                        break;
                }
            } else if (user.getType().equals(UserType.USER)) {
                UserCommand.printCommand();
                String command = scanner.nextLine();
                switch (command) {
                    case UserCommand.LOGOUT:
                        isRegistered = false;
                        break;
                    case UserCommand.PRINT_PRODUCTS:
                        productStorage.printProducts();
                        break;
                    case BUY_PRODUCT:
                        buyProduct(user);
                        break;
                    case PRINT_MY_ORDERS:
                        printMyOrders();
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
    }

    private static void addProduct() {
        System.out.println("Please input product id");
        String productId = scanner.nextLine();
        System.out.println("Please input product name");
        String name = scanner.nextLine();
        System.out.println("Please input product description");
        String description = scanner.nextLine();
        System.out.println("Please input product price");
        double price;
        int stockQty;
        ProductType type;
        try {
            price = Double.parseDouble(scanner.nextLine());
            System.out.println("Please input product stock quantity");
            stockQty = Integer.parseInt(scanner.nextLine());
            try {
                System.out.println("Please input product type (ELECTRONICS, CLOTHING, BOOKS)");
                type = ProductType.valueOf(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal type of product.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong value. Please try again");
            return;
        }
        Product product = new Product(productId, name, description, price, stockQty, type);
        productStorage.add(product);
        System.out.println("Product added.");
    }

    private static void removeProductById() {
        System.out.println("Please input product id");
        String productId = scanner.nextLine();
        Product productFromStorage = productStorage.getById(productId);
        if (productFromStorage == null) {
            System.out.println("Product with " + productId + " does not exists");
            return;
        }
        productStorage.deleteProductById(productId);
        System.out.println("Product is removed");
    }

    private static void buyProduct(User user) {
        productStorage.printProducts();
        System.out.println("Please input product id");
        String productId = scanner.nextLine();
        System.out.println("Please input product order quantity");
        int orderQty;
        try {
            orderQty = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Incorrect format. Please input only numbers");
            return;
        }
        System.out.println("Please input payment method (CARD, CASH, PAYPAL)");
        PaymentMethod paymentMethod = PaymentMethod.valueOf(scanner.nextLine());
        Product productFromStorage = productStorage.getById(productId);
        if (productFromStorage == null) {
            System.out.println("Product with " + productId + " does not exists");
            return;
        }
        try {
            productStorage.checkStockQty(orderQty, productFromStorage.getType());
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(productFromStorage.getPrice() * orderQty);
        System.out.println("Do you want to buy this product with this price? Please input 'yes', if you confirm.");
        String yes = scanner.nextLine();
        if (yes.equals("yes")) {
            System.out.println("Please input order id");
            String orderId = scanner.nextLine();

            Order order = new Order(orderId, user, productFromStorage, new Date(),
                    productFromStorage.getPrice(), OrderStatus.NEW, orderQty, paymentMethod);
            orderStorage.add(order);
            productFromStorage.setStockQty(productFromStorage.getStockQty() - orderQty);
            System.out.println("The products are purchased");
        } else {
            System.out.println("Please input only 'yes'");
        }
    }

    private static void printMyOrders() {
        System.out.println("Please input your user id");
        String userId = scanner.nextLine();
        User userFromStorage = userStorage.getById(userId);
        if (userFromStorage == null) {
            System.out.println("User with " + userId + " does not exist");
        }
        orderStorage.printMyOrders(userFromStorage);
    }

    private static void cancelOrderById() {
        System.out.println("Please input orderId");
        String orderId = scanner.nextLine();
        Order orderFromStorage = orderStorage.getById(orderId);
        if (orderFromStorage == null) {
            System.out.println("Order with " + orderId + " id does not exists");
            return;
        }
        try {
            orderFromStorage.setOrderStatus(OrderStatus.CANCELED);
        } catch (NullPointerException e) {
            System.out.println("You don't have any orders");
        }
        System.out.println("Order canceled!");
    }

    private static void setOrderDelivered() {
        System.out.println("Please input your user id");
        String userId = scanner.nextLine();
        System.out.println("Please input your order id");
        String orderId = scanner.nextLine();
        if (orderId != null) {
            orderStorage.setOrderDelivered(userId, orderId);
            System.out.println("Order status changed");
        } else {
            System.out.println("You don't have any orders");
        }
    }

    private static User login() {
        System.out.println("Please input user email");
        String email = scanner.nextLine();
        System.out.println("Please input user password");
        String password = scanner.nextLine();
        User userFromStorage = userStorage.login(email, password);
        if (userFromStorage == null) {
            System.out.println("User email or password is incorrect. Please try again.");
            return null;
        }
        return userFromStorage;
    }

    private static void register() {
        System.out.println("Please input user id");
        String userId = scanner.nextLine();
        User userFromStorage = userStorage.getById(userId);
        if (userFromStorage != null) {
            System.out.println("User with " + userId + " id already exists");
            return;
        }
        System.out.println("Please input user name");
        String name = scanner.nextLine();
        System.out.println("Please input user surname");
        String surname = scanner.nextLine();
        System.out.println("Please input user email");
        String email = scanner.nextLine();
        System.out.println("Please input user password");
        String password = scanner.nextLine();
        System.out.println("Please input user type (USER, ADMIN)");
        try {
            UserType userType = UserType.valueOf(scanner.nextLine());
            User user = new User(userId, name, surname, email, password, userType);
            userStorage.register(user);
            if (userType == UserType.USER) {
                System.out.println("User successfully registered!");
            } else {
                System.out.println("Admin successfully registered!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong user type. Please try to register again.");
        }
    }
}
