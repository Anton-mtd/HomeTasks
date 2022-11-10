package org.skomorokhin.marketautumn.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.skomorokhin.marketautumn.model.entities.Customer;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDto implements Comparable<ProductDto> {

    private Integer id;

    private String title;

    private Integer price;

    private Set<Customer> customers;

    @Override
    public int compareTo(ProductDto o) {
        return this.getId().compareTo(o.id);
    }
}


