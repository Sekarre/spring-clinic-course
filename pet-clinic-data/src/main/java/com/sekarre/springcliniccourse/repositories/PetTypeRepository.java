package com.sekarre.springcliniccourse.repositories;

import com.sekarre.springcliniccourse.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
