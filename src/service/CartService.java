package service;

import bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartService {
    private static Map<Integer, Product> products;
    private static ArrayList<Product> carts;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "xe may", 120));
        products.put(2, new Product(2, "oto", 550));
        products.put(3, new Product(3, "dien thoai", 60));
        products.put(4, new Product(4, "ipad", 100));
    }

    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    public Product add(int id) {
        return products.get(id);
    }

}
