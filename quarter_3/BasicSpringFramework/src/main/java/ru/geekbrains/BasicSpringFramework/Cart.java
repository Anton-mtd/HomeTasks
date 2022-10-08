package ru.geekbrains.BasicSpringFramework;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
@Scope("prototype")
public class Cart {

    ProductService productService;
    private List<Product> productInCart;

    public Cart(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void init() {
        productInCart = new ArrayList<>();
    }

    public void addProduct (int idProduct) {
        productInCart.add(productService.getProductById(idProduct - 1));
        System.out.println("product " + productService.getProductById(idProduct - 1).getId() + "was added");
    }

    public void removeProduct(int idProduct) {
        productInCart.remove(productService.getProductById(idProduct - 1));
        System.out.println("product " + productService.getProductById(idProduct - 1).getId() + "was removed");
    }

    public String showOrder() {
        StringBuilder sb = new StringBuilder();
        for (Product product : productInCart) {
            sb.append("id:" + product.getId() + ", ");
            sb.append("title:" + product.getTitle() + ", ");
            sb.append("price:" + product.getPrice());
            sb.append("\n");
        }
        return sb.toString();
    }
}
