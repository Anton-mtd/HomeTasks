package org.skomorokhin.marketautumn.model.data;

import org.skomorokhin.marketautumn.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Cart {

    private List<ProductDto> productInCart;


    public void addProduct(ProductDto productDto) {
        productInCart.add(productDto);
    }

    public void removeProduct(ProductDto productDto) {
        productInCart.remove(productDto);
    }

    public String showOrder() {
        StringBuilder sb = new StringBuilder();
        for (ProductDto productDto : productInCart) {
            sb.append("id:" + productDto.getId() + ", ");
            sb.append("title:" + productDto.getTitle() + ", ");
            sb.append("price:" + productDto.getPrice());
            sb.append("\n");
        }
        return sb.toString();
    }
}
