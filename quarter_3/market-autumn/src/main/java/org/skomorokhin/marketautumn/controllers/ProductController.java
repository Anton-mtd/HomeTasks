package org.skomorokhin.marketautumn.controllers;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.model.Product;
import org.skomorokhin.marketautumn.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/products/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/change_price")
    public void changeProductPrice(@RequestParam Integer productId, @RequestParam Integer delta) {
        productService.ChangeProductPrice(productId, delta);
    }

    @PostMapping("/product/add")
    public void addProduct(@RequestBody Product product) {
        productService.getAllProducts().add(product);
    }


}
