package com.sekarre.springcliniccourse.repositories;

import com.sekarre.springcliniccourse.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
