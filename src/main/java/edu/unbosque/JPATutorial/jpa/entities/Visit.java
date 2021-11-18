package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Visit") // Optional
@NamedQueries({
        @NamedQuery(name = "Visit.findById",
                query = "SELECT a FROM Visit a WHERE a.visit_id = :visit_id")
})
public class Visit {
    @Id
    @GeneratedValue
    @Column(name = "visit_id", nullable = false)
    private Integer visit_id;

    @Column(nullable = false)
    private String created_at;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String vet_id;

    @Column(nullable = false)
    private String pet_id;


    public Visit() {}

    public Visit(String created_at, String type, String description, String pet_id, String vet_id) {
        this.created_at = created_at;
        this.description = description;
        this.type = type;
        this.pet_id = pet_id;
        this.vet_id = vet_id;
    }

    public Visit(Integer visit_id, String created_at, String type, String description, String pet_id, String vet_id) {
        this.visit_id = visit_id;
        this.created_at = created_at;
        this.description = description;
        this.type = type;
        this.pet_id = pet_id;
        this.vet_id = vet_id;
    }

    public Integer getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVet_id() {
        return vet_id;
    }

    public void setVet_id(String vet_id) {
        this.vet_id = vet_id;
    }

    public String getPet_id() {
        return pet_id;
    }

    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
    }
}

