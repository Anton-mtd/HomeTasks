package org.skomorokhin.marketautumn.services;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.dto.Product;
import org.skomorokhin.marketautumn.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;



    public Product getProductByID(Integer id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

}
