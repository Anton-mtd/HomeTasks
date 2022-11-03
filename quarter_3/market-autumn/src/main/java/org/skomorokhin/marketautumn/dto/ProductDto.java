package org.skomorokhin.marketautumn.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.skomorokhin.marketautumn.model.Product;

@Data
@AllArgsConstructor
public class ProductDto implements Comparable<ProductDto> {

    public ProductDto(Product p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.price = p.getPrice();
    }


    private Integer id;


    private String title;


    private Integer price;


    @Override
    public int compareTo(ProductDto o) {
        return this.getId().compareTo(o.id);
    }
}


