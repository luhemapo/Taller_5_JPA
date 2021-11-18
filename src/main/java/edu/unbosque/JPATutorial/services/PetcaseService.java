package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Petcase;
import edu.unbosque.JPATutorial.jpa.repositories.PetcaseRepository;
import edu.unbosque.JPATutorial.jpa.repositories.PetcaseRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.PetcasePOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class PetcaseService {

    PetcaseRepository petcaseRepository;

    public Petcase savePetcase(String created_at, String type, String description, String pet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petcaseRepository = new PetcaseRepositoryImpl(entityManager);
        Petcase petcase = new Petcase(created_at, type, description, pet_id);

        Petcase persistedPetcase = petcaseRepository.save(petcase).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedPetcase;

    }
    public List<PetcasePOJO> listPetcases() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        petcaseRepository = new PetcaseRepositoryImpl(entityManager);
        List<Petcase> petcases = petcaseRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<PetcasePOJO> petcasePOJO = new ArrayList<>();
        for (Petcase petcase : petcases) {
            petcasePOJO.add(new PetcasePOJO(
                    petcase.getCase_id(),
                    petcase.getCreated_at(),
                    petcase.getType(),
                    petcase.getDescription(),
                    petcase.getPet_id()
            ));
        }

        return petcasePOJO;

    }




}

