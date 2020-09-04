package com.sekarre.springcliniccourse.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> specielities = new HashSet<>();

    public Set<Speciality> getSpecielities() {
        return specielities;
    }

    public void setSpecielities(Set<Speciality> specielities) {
        this.specielities = specielities;
    }
}
