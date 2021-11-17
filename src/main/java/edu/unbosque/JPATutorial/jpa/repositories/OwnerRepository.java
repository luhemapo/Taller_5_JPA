package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    Optional<Owner> findByUsername(String username);

    List<Owner> findAll();

    Optional<Owner> save(Owner owner);

    void deleteByUsername(String username);

}

