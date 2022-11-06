package org.skomorokhin.marketautumn.repositories;

import org.skomorokhin.marketautumn.model.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.TreeSet;

public interface ProductRepository extends CrudRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

}
