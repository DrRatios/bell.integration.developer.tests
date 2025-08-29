package com.aleksgolds.bell.integrator.developer.tests.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Basket {
    private Map<String, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    @Override
    public void addProduct(String product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity");
            return;
        }
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
        }
    }

    @Override
    public void removeProduct(String product) {
        products.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (products.containsKey(product)) {
            if (products.get(product) + quantity <= 0) {
                products.remove(product);
            } else {
                products.put(product, products.get(product) + quantity);
            }
        } else {
            if (quantity <= 0) {
                System.out.println("Invalid quantity");
                return;
            }
            products.put(product, quantity);
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        return new ArrayList<>(products.keySet());
    }

    @Override
    public int getProductQuantity(String product) {
        return products.get(product);
    }
}
