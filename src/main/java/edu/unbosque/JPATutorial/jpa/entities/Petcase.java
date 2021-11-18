package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Petcase") // Optional
@NamedQueries({
        @NamedQuery(name = "Petcase.findById",
                query = "SELECT a FROM Petcase a WHERE a.case_id = :case_id")
})
public class Petcase {
    @Id
    @GeneratedValue
    @Column(name = "case_id", nullable = false)
    private Integer case_id;

    @Column(nullable = false)
    private String created_at;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String pet_id;


    public Petcase() {}

    public Petcase(String created_at, String type, String description, String pet_id) {
        this.created_at = created_at;
        this.description = description;
        this.type = type;
        this.pet_id = pet_id;
    }

    public Petcase(Integer case_id, String created_at, String type, String description, String pet_id) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.description = description;
        this.type = type;
        this.pet_id = pet_id;
    }

    public Integer getCase_id() {
        return case_id;
    }

    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
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

    public String getPet_id() {
        return pet_id;
    }

    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
    }
}

