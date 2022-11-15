package org.skomorokhin.marketautumn.repositories;

import org.skomorokhin.marketautumn.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Integer> {
}
