package homework.onlineShop.storage;

import homework.onlineShop.enums.OrderStatus;
import homework.onlineShop.model.Order;
import homework.onlineShop.model.User;

public class OrderStorage {

    private Order[] orders = new Order[10];
    private ProductStorage productStorage = new ProductStorage();
    private int size;

    public void add(Order order) {
        if (size == orders.length) {
            extend();
        }
        orders[size++] = order;
    }

    public void printOrders() {
        for (int i = 0; i < size; i++) {
            System.out.println(orders[i]);
        }
    }

    public void printMyOrders(User user) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().equals(user)) {
                System.out.println(orders[i]);
            }
        }
    }

    public Order getById(String orderId) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(orderId)) {
                return orders[i];
            }
        }
        return null;
    }

    private void extend() {
        Order[] tmp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, tmp, 0, orders.length);
        orders = tmp;
    }

    public void setOrderDelivered(String userId, String orderId) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().getId().equals(userId) && orders[i].getId().equals(orderId)) {
                orders[i].setOrderStatus(OrderStatus.DELIVERED);
            }
        }
    }

    public void changeOrderStatus() {
        for (int i = 0; i < size; i++) {
            if(orders[i].getOrderStatus().equals(OrderStatus.DELIVERED)) {
                orders[i].setOrderStatus(OrderStatus.DELIVERED);
            }
        }
    }
}
