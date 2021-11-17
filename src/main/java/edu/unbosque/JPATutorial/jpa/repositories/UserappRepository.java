package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Userapp;

import java.util.List;
import java.util.Optional;

public interface UserappRepository {

    Optional<Userapp> findByUsername(String username);

    List<Userapp> findAll();

    Optional<Userapp> save(Userapp userapp);

    void deleteByUsername(String username);

}

