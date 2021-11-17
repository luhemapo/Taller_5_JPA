package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Vet;

import java.util.List;
import java.util.Optional;

public interface PetRepository {

    Optional<Vet> findByUsername(String username);

    List<Vet> findAll();

    Optional<Vet> save(Vet vet);

    void deleteByUsername(String username);

}

