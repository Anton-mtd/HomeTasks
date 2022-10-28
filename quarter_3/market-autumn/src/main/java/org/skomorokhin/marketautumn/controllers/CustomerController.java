package org.skomorokhin.marketautumn.controllers;

import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.model.Customer;
import org.skomorokhin.marketautumn.model.Product;
import org.skomorokhin.marketautumn.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.TreeSet;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private TreeSet <Product> selectedCustomerOrder;
    private Customer selectedCustomer;


    @GetMapping("/customer/all")
    @ResponseBody
    public TreeSet<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    @PostMapping("/customer/order")
    public void createSelectedOrder(@RequestParam Integer id) {
        selectedCustomer = customerService.getCustomerById(id);
        selectedCustomerOrder = customerService.getCustomerProducts(selectedCustomer);
    }

    @GetMapping("/customer/order")
    @ResponseBody
    public TreeSet<Product> getSelectedOrder() {
        return selectedCustomerOrder;
    }

    @GetMapping("/customer/current")
    @ResponseBody
    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

}
