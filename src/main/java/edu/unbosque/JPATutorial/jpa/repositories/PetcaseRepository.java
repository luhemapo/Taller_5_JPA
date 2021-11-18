package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Petcase;

import java.util.List;
import java.util.Optional;

public interface PetcaseRepository {

    Optional<Petcase> findById(Integer case_id);

    List<Petcase> findAll();

    Optional<Petcase> save(Petcase petcase);

    void deleteById(Integer case_id);

}

