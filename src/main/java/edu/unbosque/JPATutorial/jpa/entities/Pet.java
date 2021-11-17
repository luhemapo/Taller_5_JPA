package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pet") // Optional
@NamedQueries({
        @NamedQuery(name = "Pet.findById",
                query = "SELECT a FROM Pet a WHERE a.pet_id = :pet_id")
})
public class Pet {

    @Id
    @Column(name = "pet_id", nullable = false, length = 30)
    private String pet_id;

    @Column(nullable = false)
    private String microchip;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String race;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private String picture;

    @Column(nullable = false)
    private String person_id;


    public Pet() {}

    public Pet(String pet_id, String microchip, String name, String species, String race, String size, String sex, String picture, String person_id) {
        this.pet_id = pet_id;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
        this.person_id = person_id;

    }

    public String getPet_id() {
        return pet_id;
    }

    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }
}

