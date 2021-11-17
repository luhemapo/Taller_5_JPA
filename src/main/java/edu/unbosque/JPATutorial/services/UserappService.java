package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Userapp;
import edu.unbosque.JPATutorial.jpa.repositories.UserappRepository;
import edu.unbosque.JPATutorial.jpa.repositories.UserappRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.UserappPOJO;
import org.hibernate.internal.build.AllowSysOut;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserappService {

    UserappRepository userappRepository;

    public List<UserappPOJO> listUsersapp() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userappRepository = new UserappRepositoryImpl(entityManager);
        List<Userapp> usersapp = userappRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<UserappPOJO> usersappPOJO = new ArrayList<>();
        for (Userapp userapp : usersapp) {
            usersappPOJO.add(new UserappPOJO(
                    userapp.getUsername(),
                    userapp.getPassword(),
                    userapp.getEmail(),
                    userapp.getRole()
            ));
        }

        return usersappPOJO;

    }

    public Userapp saveUserapp(String username, String password, String email, String role) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userappRepository = new UserappRepositoryImpl(entityManager);
        Userapp userapp = new Userapp(username, password, email, role);

        Userapp persistedUserapp = userappRepository.save(userapp).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedUserapp;

    }

    public void deleteUserapp(String username) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userappRepository = new UserappRepositoryImpl(entityManager);
        userappRepository.deleteByUsername(username);

        entityManager.close();
        entityManagerFactory.close();

    }

}

