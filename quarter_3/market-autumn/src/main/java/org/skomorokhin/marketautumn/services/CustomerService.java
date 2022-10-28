package org.skomorokhin.marketautumn.services;

import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.model.Customer;
import org.skomorokhin.marketautumn.model.Product;
import org.skomorokhin.marketautumn.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public TreeSet<Customer> getAllCustomers() {
        TreeSet<Customer> customers = new TreeSet<>();
        for (Customer customer : customerRepository.findAll()) {
            customers.add(customer);
        }
        return customers;
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).get();
    }

    public TreeSet<Product> getCustomerProducts(Customer customer) {
        TreeSet<Product> products = new TreeSet<>(customer.getProducts());
        return products;
    }
}
