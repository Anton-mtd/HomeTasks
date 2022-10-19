package org.skomorokhin.marketautumn.controllers;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/product")
    public String productInfo(Model model, @RequestParam Integer id) {
        model.addAttribute("product", productService.getProductByID(id));
        return "product.html";
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products.html";
    }
}
