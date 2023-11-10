package homework.onlineStore.storage;

import homework.onlineStore.model.Order;
import homework.onlineStore.model.User;
import homework.onlineStore.util.StorageSerializeUtil;

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

    public void printByUser(User currentUser) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().equals(currentUser)) {
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
}
