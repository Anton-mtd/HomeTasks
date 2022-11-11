package org.skomorokhin.marketautumn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.skomorokhin.marketautumn.converters.ProductConverter;
import org.skomorokhin.marketautumn.model.data.Cart;
import org.skomorokhin.marketautumn.model.entities.Customer;
import org.skomorokhin.marketautumn.model.entities.Product;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerDto implements Comparable<Customer>  {

    private Cart cart;

    private Integer id;

    private String name;

    private Set<Product> products;

    public Set<ProductDto> getProducts() {
        return products.stream().map(ProductConverter::productToDto).collect(Collectors.toSet());
    }

    @Override
    public int compareTo(Customer o) {
        return this.getName().compareTo(o.getName());
    }
}
