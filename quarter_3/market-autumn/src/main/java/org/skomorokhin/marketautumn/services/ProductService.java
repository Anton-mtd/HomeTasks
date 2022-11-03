package org.skomorokhin.marketautumn.services;


import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.dto.ProductDto;
import org.skomorokhin.marketautumn.model.Customer;
import org.skomorokhin.marketautumn.model.Product;
import org.skomorokhin.marketautumn.repositories.ProductRepository;
import org.skomorokhin.marketautumn.repositories.specification.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<Product> find(Integer p, Integer minPrice, Integer maxPrice) {
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(ProductSpecification.priceGreaterOrEqualsThan(minPrice));
        } if (maxPrice != null) {
            spec = spec.and(ProductSpecification.priceLessOrEqualsThan(maxPrice));
        }
        return productRepository.findAll(spec, PageRequest.of(p -1, 10));
    }

    public ProductDto getProductByID(Integer id) {
        return productRepository.findById(id).map(p -> new ProductDto(p)).orElseThrow();
    }

    public TreeSet<ProductDto> getAllProducts() {
        TreeSet<ProductDto> products = new TreeSet<>();
        productRepository.findAll().forEach(p -> products.add(new ProductDto(p)));
        return products;
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public TreeSet<Customer> getProductCustomers(ProductDto productDto){
        Product product = productRepository.findById(productDto.getId()).orElseThrow();
        return new TreeSet<>(product.getCustomers());
    }
}
