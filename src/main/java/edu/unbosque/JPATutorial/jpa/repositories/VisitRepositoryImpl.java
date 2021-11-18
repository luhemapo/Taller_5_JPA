package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Visit;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VisitRepositoryImpl implements VisitRepository {

    private EntityManager entityManager;

    public VisitRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Visit> findAll() {
        return entityManager.createQuery("from Visit").getResultList();
    }

    public Optional<Visit> findById(Integer id) {
        Visit visit = entityManager.find(Visit.class, id);
        return visit != null ? Optional.of(visit) : Optional.empty();
    }

    public Optional<Visit> save(Visit visit) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return Optional.of(visit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer visit_id) {
        Visit visit = entityManager.find(Visit.class, visit_id);
        if (visit != null) {
            try {

                entityManager.getTransaction().begin();

                entityManager.remove(visit);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

