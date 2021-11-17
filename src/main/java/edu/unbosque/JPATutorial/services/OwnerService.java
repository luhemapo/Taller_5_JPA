package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Owner;
import edu.unbosque.JPATutorial.jpa.entities.Vet;
import edu.unbosque.JPATutorial.jpa.repositories.OwnerRepository;
import edu.unbosque.JPATutorial.jpa.repositories.OwnerRepositoryImpl;
import edu.unbosque.JPATutorial.jpa.repositories.VetRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.OwnerPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.VetPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class OwnerService {

    OwnerRepository ownerRepository;

    public Owner saveOwner(String username, String name, String address, String neighborhood, String person_id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Owner owner = new Owner(username, name, address, neighborhood, person_id);

        Owner persistedOwner = ownerRepository.save(owner).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedOwner;

    }


    public void updateOwner(String username, String name, String address, String neighborhood){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        Optional<Owner> owner = ownerRepository.findByUsername(username);
        entityManager.getTransaction().begin();
        owner.get().setName(name);
        owner.get().setAddress(address);
        owner.get().setNeighborhood(neighborhood);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    public List<OwnerPOJO> listOwners() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ownerRepository = new OwnerRepositoryImpl(entityManager);
        List<Owner> owners = ownerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<OwnerPOJO> ownerPOJO = new ArrayList<>();
        for (Owner owner : owners) {
            ownerPOJO.add(new OwnerPOJO(
                    owner.getUsername(),
                    owner.getName(),
                    owner.getAddress(),
                    owner.getNeighborhood(),
                    owner.getPerson_id()
            ));
        }

        return ownerPOJO;

    }

}

