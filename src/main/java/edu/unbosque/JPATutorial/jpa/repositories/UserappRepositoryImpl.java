package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Userapp;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UserappRepositoryImpl implements UserappRepository {

    private EntityManager entityManager;

    public UserappRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // public Optional<Userapp> findByUsername(String username) {
    //   Userapp userapp = entityManager.find(Userapp.class, username);
    // return userapp != null ? Optional.of(userapp) : Optional.empty();
    //}

    public List<Userapp> findAll() {
        return entityManager.createQuery("from Userapp").getResultList();
    }

    public Optional<Userapp> findByUsername(String username) {
        Userapp userapp = entityManager.createNamedQuery("Userapp.findByUsername", Userapp.class)
                .setParameter("username", username)
                .getSingleResult();
        return userapp != null ? Optional.of(userapp) : Optional.empty();
    }

    public Optional<Userapp> save(Userapp userapp) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userapp);
            entityManager.getTransaction().commit();
            return Optional.of(userapp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteByUsername(String username) {
        Userapp userapp = entityManager.find(Userapp.class, username);
        if (userapp != null) {
            try {

                entityManager.getTransaction().begin();

                entityManager.remove(userapp);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

