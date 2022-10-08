package ru.geekbrains.BasicSpringFramework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {

    private static Scanner scanner = new Scanner(System.in);
    private static ProductService productService;
    private static Cart cart;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru/geekbrains/BasicSpringFramework");

        productService = context.getBean(ProductService.class);
        cart = context.getBean(Cart.class);

        System.out.println("Welcome to consoleMarket!");
        System.out.println("Type:\n" +
                "-showAll for allProductList;\n" +
                "-add \"id\" for adding product to the Cart with use accordingly product id\n" +
                "-remove \"id\" for removing from the Cart with use accordingly product id\n" +
                "-showOrder show products in the Cart\n" +
                "-exit close session");
        while (true){
            defineCommand();
        }
    }

    public static void defineCommand() {
        String command = scanner.nextLine().toString();
        if (command.contains("-showAll")) {
            System.out.println(productService.getAllProducts());
        } else if (command.contains("-add")) {
            cart.addProduct(Integer.parseInt(command.split(" ")[1]));
        } else if (command.contains("-remove")) {
            cart.removeProduct(Integer.parseInt(command.split(" ")[1]));
        } else if (command.contains("-showOrder")) {
            System.out.println(cart.showOrder());
        } else if (command.equals("-exit")) {
            System.exit(0);
        }
    }
}
