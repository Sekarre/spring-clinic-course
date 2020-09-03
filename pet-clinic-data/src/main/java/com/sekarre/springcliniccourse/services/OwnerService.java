package com.sekarre.springcliniccourse.services;

import com.sekarre.springcliniccourse.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
