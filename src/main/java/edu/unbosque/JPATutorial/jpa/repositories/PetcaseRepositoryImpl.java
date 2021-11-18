package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Petcase;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetcaseRepositoryImpl implements PetcaseRepository {

    private EntityManager entityManager;

    public PetcaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Petcase> findAll() {
        return entityManager.createQuery("from Petcase").getResultList();
    }

    public Optional<Petcase> findById(Integer id) {
        Petcase petcase = entityManager.find(Petcase.class, id);
        return petcase != null ? Optional.of(petcase) : Optional.empty();
    }

    public Optional<Petcase> save(Petcase petcase) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(petcase);
            entityManager.getTransaction().commit();
            return Optional.of(petcase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer case_id) {
        Petcase petcase = entityManager.find(Petcase.class, case_id);
        if (petcase != null) {
            try {

                entityManager.getTransaction().begin();

                entityManager.remove(petcase);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

