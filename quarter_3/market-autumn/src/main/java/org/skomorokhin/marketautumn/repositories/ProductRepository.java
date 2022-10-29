package org.skomorokhin.marketautumn.repositories;

import org.skomorokhin.marketautumn.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
