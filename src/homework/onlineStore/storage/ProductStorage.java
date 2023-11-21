package homework.onlineStore.storage;

import homework.onlineStore.model.Product;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashSet;

public class ProductStorage implements Serializable {

    private HashSet<Product> products = new HashSet<>();

    public void add(Product product) {
        products.add(product);
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public void print() {
        for (Product product : products) {
            if (!product.isRemoved()) {
                System.out.println(product);
            }
        }
    }

    public Product getById(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId) && !product.isRemoved()) {
                return product;
            }
        }
        return null;
    }
}
