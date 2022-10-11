package ru.geekbrains.BasicSpringFramework;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1, "Bread", 50),
                new Product(2,"Milk",80),
                new Product(3, "Orange", 100),
                new Product(4,"Cheese", 250),
                new Product(5,"Tea",60)
        ));
    }

    public Product findById(int id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<Product> getProducts() {
        return products;
    }
}
