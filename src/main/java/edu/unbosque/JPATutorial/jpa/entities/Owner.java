package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Owner") // Optional
@NamedQueries({
        @NamedQuery(name = "Owner.findByUsername",
                query = "SELECT a FROM Owner a WHERE a.username = :username")
})
public class Owner {

    @Id
    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String person_id;


    public Owner() {}

    public Owner(String username, String name, String address, String neighborhood, String person_id) {
        this.username = username;
        this.name=name;
        this.address=address;
        this.neighborhood=neighborhood;
        this.person_id = person_id;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }
}

