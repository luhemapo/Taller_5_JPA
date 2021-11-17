package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VetRepositoryImpl implements VetRepository {

    private EntityManager entityManager;

    public VetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Vet> findAll() {
        return entityManager.createQuery("from Vet").getResultList();
    }

    public Optional<Vet> findByUsername(String username) {
        Vet vet = entityManager.createNamedQuery("Vet.findByUsername", Vet.class)
                .setParameter("username", username)
                .getSingleResult();
        return vet != null ? Optional.of(vet) : Optional.empty();
    }

    public Optional<Vet> save(Vet vet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vet);
            entityManager.getTransaction().commit();
            return Optional.of(vet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteByUsername(String username) {
        Vet vet = entityManager.find(Vet.class, username);
        if (vet != null) {
            try {

                entityManager.getTransaction().begin();

                entityManager.remove(vet);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

