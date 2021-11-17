package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Official;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OfficialRepositoryImpl implements OfficialRepository {

    private EntityManager entityManager;

    public OfficialRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Official> findAll() {
        return entityManager.createQuery("from Official").getResultList();
    }

    public Optional<Official> findByUsername(String username) {
        Official official = entityManager.createNamedQuery("Official.findByUsername", Official.class)
                .setParameter("username", username)
                .getSingleResult();
        return official != null ? Optional.of(official) : Optional.empty();
    }

    public Optional<Official> save(Official official) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(official);
            entityManager.getTransaction().commit();
            return Optional.of(official);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteByUsername(String username) {
        Official official = entityManager.find(Official.class, username);
        if (official != null) {
            try {

                entityManager.getTransaction().begin();
                entityManager.remove(official);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

