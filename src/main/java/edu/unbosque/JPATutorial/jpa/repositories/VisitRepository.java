package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Visit;

import java.util.List;
import java.util.Optional;

public interface VisitRepository {

    Optional<Visit> findById(Integer visit_id);

    List<Visit> findAll();

    Optional<Visit> save(Visit visit);

    void deleteById(Integer visit_id);

}

