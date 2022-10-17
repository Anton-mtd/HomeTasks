package org.skomorokhin.marketautumn.repositories;

import org.skomorokhin.marketautumn.model.Product;
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
                new Product(1, "Bread", 50l),
                new Product(2,"Milk",80l),
                new Product(3, "Orange", 100l),
                new Product(4,"Cheese", 250l),
                new Product(5,"Tea",60l)
        ));
    }

    public Product findById(int id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Product is not found"));
    }

    public List<Product> getProducts() {
        return products;
    }
}
