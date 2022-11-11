package org.skomorokhin.marketautumn.repositories;


import org.skomorokhin.marketautumn.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
}
