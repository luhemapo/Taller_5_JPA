package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Userapp;
import edu.unbosque.JPATutorial.jpa.entities.Vet;
import edu.unbosque.JPATutorial.jpa.repositories.*;
import edu.unbosque.JPATutorial.servlets.pojos.UserappPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.VetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class VetService {

    VetRepository vetRepository;

    public Vet saveVet(String username, String name, String address, String neighborhood, String vet_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        Vet vet = new Vet(username, name, address, neighborhood, vet_id);

        Vet persistedVet = vetRepository.save(vet).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedVet;

    }

    public void updateVet(String username, String name, String address, String neighborhood){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        Optional<Vet> vet = vetRepository.findByUsername(username);
        entityManager.getTransaction().begin();
        vet.get().setName(name);
        vet.get().setAddress(address);
        vet.get().setNeighborhood(neighborhood);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    public List<VetPOJO> listVets() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        vetRepository = new VetRepositoryImpl(entityManager);
        List<Vet> vets = vetRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<VetPOJO> vetPOJO = new ArrayList<>();
        for (Vet vet : vets) {
            vetPOJO.add(new VetPOJO(
                    vet.getUsername(),
                    vet.getName(),
                    vet.getAddress(),
                    vet.getNeighborhood(),
                    vet.getVet_id()
            ));
        }

        return vetPOJO;

    }




}

