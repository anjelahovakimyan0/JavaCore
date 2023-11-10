package homework.onlineStore.storage;

import homework.onlineStore.model.Product;
import homework.onlineStore.model.enums.ProductType;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;

public class ProductStorage implements Serializable {

    private Product[] products = new Product[10];
    private int size;

    public void add(Product product) {
        if (size == products.length) {
            extend();
        }
        products[size++] = product;
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (!products[i].isRemoved()) {
                System.out.println(products[i]);
            }
        }
    }

    public Product getById(String productId) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(productId) && !products[i].isRemoved()) {
                return products[i];
            }
        }
        return null;
    }

    public void deleteProductById(String productId) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(productId)) {
                for (int j = i + 1; j < size; j++) {
                    products[j - 1] = products[j];
                }
                size--;
            }
        }
        StorageSerializeUtil.serializeProductStorage(this);
    }

    private void extend() {
        Product[] tmp = new Product[products.length + 10];
        System.arraycopy(products, 0, tmp, 0, products.length);
        products = tmp;
    }
}
