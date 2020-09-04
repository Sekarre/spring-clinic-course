package com.sekarre.springcliniccourse.bootstrap;

import com.sekarre.springcliniccourse.model.*;
import com.sekarre.springcliniccourse.services.OwnerService;
import com.sekarre.springcliniccourse.services.PetTypeService;
import com.sekarre.springcliniccourse.services.SpecialtyService;
import com.sekarre.springcliniccourse.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgry = specialtyService.save(surgery);


        Speciality dentistry = new Speciality();
        dentistry.setDescription("Densitry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Adam");
        owner1.setLastName("Miak");
        owner1.setAddress("123 Ald");
        owner1.setCity("London");
        owner1.setTelephone("125125123213");
        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fio");
        owner2.setLastName("Anar");
        owner2.setAddress("123 Ald");
        owner2.setCity("London");
        owner2.setTelephone("125125123213");
        ownerService.save(owner2);

        Pet fionasCat = new Pet();
        fionasCat.setName("Just cat");
        fionasCat.setOwner(owner1);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        System.out.println("Loaded Owners...");

        Vet ve1 = new Vet();
        ve1.setFirstName("Meh");
        ve1.setLastName("Yea");
        ve1.getSpecielities().add(savedRadiology);
        vetService.save(ve1);

        Vet ve2 = new Vet();
        ve2.setFirstName("Sam");
        ve2.setLastName("Sword");
        ve2.getSpecielities().add(savedSurgry);
        vetService.save(ve2);

        System.out.println("Loaded Vets..");
    }
}
