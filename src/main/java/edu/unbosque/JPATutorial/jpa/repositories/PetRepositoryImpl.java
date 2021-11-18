package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Pet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetRepositoryImpl implements PetRepository {

    private EntityManager entityManager;

    public PetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Pet> findAll() {
        return entityManager.createQuery("from Pet").getResultList();
    }

    public Optional<Pet> findById(String pet_id) {
        Pet pet = entityManager.createNamedQuery("Pet.findById", Pet.class)
                .setParameter("pet_id", pet_id)
                .getSingleResult();
        return pet != null ? Optional.of(pet) : Optional.empty();
    }

    public Optional<Pet> save(Pet pet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pet);
            entityManager.getTransaction().commit();
            return Optional.of(pet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(String pet_id) {
        Pet pet = entityManager.find(Pet.class, pet_id);
        if (pet != null) {
            try {

                entityManager.getTransaction().begin();

                entityManager.remove(pet);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

