package homework.onlineShop;

import homework.onlineShop.exception.OutOfStockException;
import homework.onlineShop.model.*;
import homework.onlineShop.storage.OrderStorage;
import homework.onlineShop.storage.ProductStorage;
import homework.onlineShop.storage.UserStorage;
import homework.onlineShop.util.OrderIdUtil;

import java.util.Date;
import java.util.Scanner;

public class OnlineShopMain implements Command {

    private static Scanner scanner = new Scanner(System.in);
    private static UserStorage userStorage = new UserStorage();
    private static ProductStorage productStorage = new ProductStorage();
    private static OrderStorage orderStorage = new OrderStorage();
    private static User currentUser = null;

    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            Command.printCommands();
            String command = scanner.nextLine();
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
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    private static void adminCommands() {
        boolean isRun = true;

        while (isRun) {
            Command.printAdminCommands();
            String command = scanner.nextLine();
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
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    private static void userCommands() {
        boolean isRun = true;

        while (isRun) {
            Command.printUserCommands();
            String command = scanner.nextLine();
            switch (command) {
                case Command.LOGOUT:
                    isRun = false;
                    break;
                case PRINT_PRODUCTS:
                    productStorage.printProducts();
                    break;
                case BUY_PRODUCT:
                    buyProduct();
                    break;
                case PRINT_MY_ORDERS:
                    orderStorage.printMyOrders(currentUser);
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

    private static void buyProduct() {
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
        System.out.println("$" + productFromStorage.getPrice() * orderQty);
        System.out.println("Do you want to buy this product with this price? Please input 'yes', if you confirm.");
        String yes = scanner.nextLine();
        if (yes.equals("yes")) {
            Order order = new Order(OrderIdUtil.generateId(), currentUser, productFromStorage, new Date(),
                    productFromStorage.getPrice(), OrderStatus.NEW, orderQty, paymentMethod);
            orderStorage.add(order);
            productFromStorage.setStockQty(productFromStorage.getStockQty() - orderQty);
            System.out.println("The products are purchased");
        } else {
            System.out.println("Please input only 'yes'");
        }
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

    private static void login() {
        System.out.println("Please input user email");
        String email = scanner.nextLine();
        System.out.println("Please input user password");
        String password = scanner.nextLine();
        User userFromStorage = userStorage.login(email, password);
        if (userFromStorage != null) {
            if (userFromStorage.getType() == UserType.USER) {
                currentUser = userFromStorage;
                userCommands();
            } else if (userFromStorage.getType() == UserType.ADMIN) {
                adminCommands();
            }
        } else {
            System.out.println("User email or password is incorrect. Please try again.");
        }
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
