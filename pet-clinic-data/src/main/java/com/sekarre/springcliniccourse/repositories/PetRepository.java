package com.sekarre.springcliniccourse.repositories;

import com.sekarre.springcliniccourse.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
