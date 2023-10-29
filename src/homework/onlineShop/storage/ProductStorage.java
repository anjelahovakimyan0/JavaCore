package homework.onlineShop.storage;

import homework.onlineShop.model.ProductType;
import homework.onlineShop.exception.OutOfStockException;
import homework.onlineShop.model.Product;

public class ProductStorage {

    private Product[] products = new Product[10];
    private int size;

    public void add(Product product) {
        if (size == products.length) {
            extend();
        }
        products[size++] = product;
    }

    public void printProducts() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }

    public Product getById(String productId) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(productId)) {
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
    }

    public void deleteProducts(int count, ProductType type) {
        while (count != 0) {
            for (int i = 0; i < size; i++) {
                if (products[i].getType().equals(type)) {
                    for (int j = i + 1; j < size; j++) {
                        products[j - 1] = products[j];
                    }
                    size--;
                }
            }
        }
    }

    public void checkStockQty(double stockQty, ProductType type) throws OutOfStockException {
        for (int i = 0; i < size; i++) {
            if (products[i].getType().equals(type) && products[i].getStockQty() < stockQty) {
                throw new OutOfStockException("This amount of products are not available now. Please buy less.");
            }
        }
    }

    private void extend() {
        Product[] tmp = new Product[products.length + 10];
        System.arraycopy(products, 0, tmp, 0, products.length);
        products = tmp;
    }
}
