package homework.onlineStore.storage;

import homework.onlineStore.model.Product;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

public class ProductStorage implements Serializable {

    private HashSet<Product> products = new HashSet<>();

    public void add(Product product) {
        products.add(product);
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public void print() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product getById(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public void delete(String productId) {
//        for (Product product : products) {
//            if (product.getId().equals(productId)) {
//                products.remove(product);
//                break;
//            }
//        }

//        products.removeIf(next -> next.getId().equals(productId));

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product next = iterator.next();
            if (next.getId().equals(productId)) {
                iterator.remove();
            }
        }
    }
}
