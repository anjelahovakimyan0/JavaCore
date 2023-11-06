package homework.onlineShop.storage;

import homework.onlineShop.model.Order;
import homework.onlineShop.model.OrderStatus;
import homework.onlineShop.model.User;
import homework.onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;

public class OrderStorage implements Serializable {

    private Order[] orders = new Order[10];
    private int size;

    public void add(Order order) {
        if (size == orders.length) {
            extend();
        }
        orders[size++] = order;
        StorageSerializeUtil.serializeOrderStorage(this);
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

    public void changeOrderStatus(Order order, OrderStatus orderStatus) {
        order.setOrderStatus(orderStatus);
        StorageSerializeUtil.serializeOrderStorage(this);
    }

    private void extend() {
        Order[] tmp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, tmp, 0, orders.length);
        orders = tmp;
    }
}
