package org.skomorokhin.marketautumn.services;


import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.model.Customer;
import org.skomorokhin.marketautumn.model.Product;
import org.skomorokhin.marketautumn.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Product getProductByID(Integer id) {
        return productRepository.findById(id).get();
    }

    public TreeSet<Product> getAllProducts() {
        TreeSet<Product> products = new TreeSet<>();
        Iterator<Product> iterator = productRepository.findAll().iterator();
        while (iterator.hasNext()) {
            products.add(iterator.next());
        }
        return products;
    }

    public void ChangeProductPrice(Integer id, Integer price) {
        Product product = getProductByID(id);
        product.setPrice(product.getPrice() + price);
        productRepository.save((product));
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public TreeSet<Customer> getProductCustomers(Product product){
        TreeSet<Customer> customers = new TreeSet<>(product.getCustomers());
        return  customers;
    }

}
