package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Visit;
import edu.unbosque.JPATutorial.jpa.repositories.VisitRepository;
import edu.unbosque.JPATutorial.jpa.repositories.VisitRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.VisitPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VisitService {

    VisitRepository visitRepository;

    public Visit saveVisit(String created_at, String type, String description, String pet_id, String vet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        Visit visit = new Visit(created_at, type, description, pet_id, vet_id);

        Visit persistedVisit = visitRepository.save(visit).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVisit;

    }
    public List<VisitPOJO> listVisits() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        visitRepository = new VisitRepositoryImpl(entityManager);
        List<Visit> visits = visitRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VisitPOJO> visitPOJO = new ArrayList<>();
        for (Visit visit : visits) {
            visitPOJO.add(new VisitPOJO(
                    visit.getVisit_id(),
                    visit.getCreated_at(),
                    visit.getType(),
                    visit.getDescription(),
                    visit.getPet_id(),
                    visit.getVet_id()
            ));
        }

        return visitPOJO;

    }




}

