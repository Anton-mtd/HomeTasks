package org.skomorokhin.marketautumn.controllers;

import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.dto.CustomerDto;
import org.skomorokhin.marketautumn.dto.ProductDto;
import org.skomorokhin.marketautumn.services.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/showAll")
    public Page<CustomerDto> getAllCustomers(@RequestParam (name = "page", defaultValue = "1") Integer page) {
        if (page < 1) {
            page = 1;
        }
        return customerService.find(page);
    }

    @PostMapping ("/customer")
    public void add(@RequestBody CustomerDto customerDto) {
        customerService.add(customerDto);
    }

    @PutMapping("/customer")
    public void update(@RequestBody CustomerDto customerDto) {
        customerService.update(customerDto);
    }

    @DeleteMapping("/customer")
    public void deleteProductById(@RequestParam Integer id) {
        customerService.deleteById(id);
    }

    @GetMapping("/putInCart")
    public void addProductInCart(@RequestBody CustomerDto customerDto, @RequestBody ProductDto productDto) {
        customerService.findByID(customerDto.getId()).getCart().addProduct(productDto);
    }

    @GetMapping("/deleteFromCart")
    public void deleteProductFromCart(@RequestBody CustomerDto customerDto, @RequestBody ProductDto productDto) {
        customerService.findByID(customerDto.getId()).getCart().removeProduct(productDto);
    }
}
