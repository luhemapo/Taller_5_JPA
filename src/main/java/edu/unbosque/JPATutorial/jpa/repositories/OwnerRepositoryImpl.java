package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OwnerRepositoryImpl implements OwnerRepository {

    private EntityManager entityManager;

    public OwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Owner> findAll() {
        return entityManager.createQuery("from Owner").getResultList();
    }

    public Optional<Owner> findByUsername(String username) {
        Owner owner = entityManager.createNamedQuery("Owner.findByUsername", Owner.class)
                .setParameter("username", username)
                .getSingleResult();
        return owner != null ? Optional.of(owner) : Optional.empty();
    }

    public Optional<Owner> save(Owner owner) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(owner);
            entityManager.getTransaction().commit();
            return Optional.of(owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteByUsername(String username) {
        Owner owner = entityManager.find(Owner.class, username);
        if (owner != null) {
            try {

                entityManager.getTransaction().begin();

                entityManager.remove(owner);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

