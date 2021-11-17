package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Official;
import edu.unbosque.JPATutorial.jpa.repositories.OfficialRepository;
import edu.unbosque.JPATutorial.jpa.repositories.OfficialRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.OfficialPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class OfficialService {

    OfficialRepository officialRepository;

    public Official saveOfficial(String username, String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        Official official = new Official(username, name);

        Official persistedOfficial = officialRepository.save(official).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOfficial;
    }



    public void updateOfficial(String username, String name){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        Optional<Official> official = officialRepository.findByUsername(username);
        entityManager.getTransaction().begin();
        official.get().setName(name);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    public List<OfficialPOJO> listOfficials() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        officialRepository = new OfficialRepositoryImpl(entityManager);
        List<Official> officials = officialRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OfficialPOJO> officialPOJO = new ArrayList<>();
        for (Official official : officials) {
            officialPOJO.add(new OfficialPOJO(
                    official.getUsername(),
                    official.getName()
            ));
        }

        return officialPOJO;

    }

}

