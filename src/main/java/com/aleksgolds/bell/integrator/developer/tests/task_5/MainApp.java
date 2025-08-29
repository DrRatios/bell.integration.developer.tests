package com.aleksgolds.bell.integrator.developer.tests.task_5;

public class MainApp {

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addProduct("Молоко", 5);
        cart.addProduct("Хлеб", 5);
        cart.addProduct("Мясо", 5);

        System.out.println(cart.getProducts());
        System.out.println(cart.getProductQuantity("Молоко"));
        System.out.println(cart.getProductQuantity("Хлеб"));
        System.out.println(cart.getProductQuantity("Мясо"));

        cart.removeProduct("Молоко");
        cart.updateProductQuantity("Хлеб", 5);
        cart.updateProductQuantity("Мясо", -4);

        System.out.println(cart.getProducts());
        try {
            System.out.println(cart.getProductQuantity("Молоко"));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println(cart.getProductQuantity("Хлеб"));
        System.out.println(cart.getProductQuantity("Мясо"));

        cart.updateProductQuantity("Мясо", -1);

        System.out.println(cart.getProducts());
        try {
            System.out.println(cart.getProductQuantity("Мясо"));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println(cart.getProductQuantity("Хлеб"));
    }
}
