package org.skomorokhin.marketautumn.services;

import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.converters.CustomerConverter;
import org.skomorokhin.marketautumn.dto.CustomerDto;
import org.skomorokhin.marketautumn.dto.ProductDto;
import org.skomorokhin.marketautumn.exceptions.ValidateException;
import org.skomorokhin.marketautumn.model.entities.Customer;
import org.skomorokhin.marketautumn.model.entities.Product;
import org.skomorokhin.marketautumn.repositories.CustomerRepository;
import org.skomorokhin.marketautumn.validators.CustomerValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;
    private final List<ProductDto> cart;


    public Page<CustomerDto> find(Integer p) {
        Specification<Customer> spec = Specification.where(null);
        return customerRepository.findAll(spec, PageRequest.of(-1,10)).map(CustomerConverter::customerToDto);
    }

    public CustomerDto findByID(Integer id) {
        return customerRepository.findById(id).map(CustomerConverter::customerToDto).orElseThrow();
    }

    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    public CustomerDto add(CustomerDto customerDto) {
        customerValidator.validate(customerDto);
        customerRepository.save(CustomerConverter.dtoToCustomer(customerDto));
        return customerDto;
    }

    @Transactional
    public CustomerDto update(CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerDto.getId()).orElseThrow(
                () -> new ValidateException(List.of("Покупатель с id=" + customerDto.getId() + " не существует")));
        customer.setName(customerDto.getName());
        return customerDto;
    }

    public TreeSet<Product> getCustomerProducts(CustomerDto customerDto) {
        TreeSet products = new TreeSet<>(customerDto.getProducts());
        return products;
    }
}
