package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Pet;
import edu.unbosque.JPATutorial.jpa.repositories.PetRepository;
import edu.unbosque.JPATutorial.jpa.repositories.PetRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.PetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class PetService {

    PetRepository petRepository;

    public Pet savePet(String pet_id, String microchip, String name, String species, String race, String size, String sex, String picture, String person_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        Pet pet = new Pet(pet_id, microchip, name, species, race, size, sex, picture, person_id);

        Pet persistedPet = petRepository.save(pet).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedPet;

    }

    public void updatePet(String pet_id, String name, String species, String race, String size, String sex, String picture){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        Optional<Pet> pet = petRepository.findById(pet_id);
        entityManager.getTransaction().begin();
        pet.get().setName(name);
        pet.get().setSpecies(species);
        pet.get().setRace(race);
        pet.get().setSize(size);
        pet.get().setSex(sex);
        pet.get().setPicture(picture);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    public List<PetPOJO> listPets() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petRepository = new PetRepositoryImpl(entityManager);
        List<Pet> pets = petRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<PetPOJO> petPOJO = new ArrayList<>();
        for (Pet pet : pets) {
            petPOJO.add(new PetPOJO(
                    pet.getPet_id(),
                    pet.getMicrochip(),
                    pet.getName(),
                    pet.getSpecies(),
                    pet.getRace(),
                    pet.getSize(),
                    pet.getSex(),
                    pet.getPicture(),
                    pet.getPerson_id()
            ));
        }

        return petPOJO;

    }




}

