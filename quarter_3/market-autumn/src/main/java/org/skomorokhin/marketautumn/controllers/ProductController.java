package org.skomorokhin.marketautumn.controllers;


import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.model.Customer;
import org.skomorokhin.marketautumn.model.Product;
import org.skomorokhin.marketautumn.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.TreeSet;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private TreeSet <Customer> selectedCustomerList;
    private Product selectedProduct;


    @GetMapping("/product/all")
    @ResponseBody
    public TreeSet<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/change_price")
    @ResponseBody
    public void changeProductPrice(@RequestParam Integer productId, @RequestParam Integer delta) {
        productService.ChangeProductPrice(productId, delta);
    }


    @GetMapping ("/product/add")
    @ResponseBody
    public void addProduct(@RequestParam String title, @RequestParam Integer price) {
        Product product = new Product(title,price);
        productService.addProduct(product);
    }

    @DeleteMapping("/product/delete")
    @ResponseBody
    public void deleteProductById(@RequestParam Integer id) {
        productService.deleteById(id);
    }

    @PostMapping("/product/customerList")
    public void setSelectedCustomerList(@RequestParam Integer id) {
        selectedProduct = productService.getProductByID(id);
        selectedCustomerList = productService.getProductCustomers(selectedProduct);
    }

    @GetMapping("/product/customerList")
    @ResponseBody
    public TreeSet<Customer> getSelectedCustomerList() {
        return selectedCustomerList;
    }

    @GetMapping("/product/current")
    @ResponseBody
    public Product getSelectedProduct() {
        return selectedProduct;
    }



}
