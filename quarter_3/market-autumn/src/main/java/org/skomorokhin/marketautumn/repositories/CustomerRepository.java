package org.skomorokhin.marketautumn.repositories;


import org.skomorokhin.marketautumn.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository <Customer, Integer> {
}
