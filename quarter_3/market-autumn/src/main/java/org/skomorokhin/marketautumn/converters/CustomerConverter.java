package org.skomorokhin.marketautumn.converters;

import org.skomorokhin.marketautumn.dto.CustomerDto;
import org.skomorokhin.marketautumn.model.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


public class CustomerConverter {


    public static Customer dtoToCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .products(customerDto.getProducts().stream().map(ProductConverter::dtoToProduct).collect(Collectors.toSet()))
                .build();
    }

    public static CustomerDto customerToDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .products(customer.getProducts())
                .build();
    }

}
