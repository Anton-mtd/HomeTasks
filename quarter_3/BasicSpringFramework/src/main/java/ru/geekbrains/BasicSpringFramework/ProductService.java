package ru.geekbrains.BasicSpringFramework;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getTitleById(int id) {
        return productRepository.findById(id).getTitle();
    }

    public Product getProductById(int id) {
        return productRepository.getProducts().get(id);
    }

    public String getAllProducts() {
        StringBuilder sb = new StringBuilder();
        for (Product product : productRepository.getProducts()) {
            sb.append("id:" + product.getId() + ", ");
            sb.append("title:" + product.getTitle() + ", ");
            sb.append("price:" + product.getPrice());
            sb.append("\n");
        }
        return sb.toString();
    }

}
